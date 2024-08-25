const fs = require("fs");
const path = require("path");

const relativePath = "ms-books/src/main/resources/data/books-seeder.json";
// const filePath = path.join(__dirname, "books-seeder.json");
const filePath = path.join(__dirname, relativePath);
fs.readFile(filePath, "utf8", (err, data) => {
  if (err) {
    console.error("Error reading the file:", err);
    return;
  }

  let books;
  try {
    books = JSON.parse(data);
  } catch (parseErr) {
    console.error("Error parsing JSON:", parseErr);
    return;
  }

  books.forEach((book) => {
    if (book.publishedDate) {
      try {
        const date = new Date(book.publishedDate);
        book.publishedDate = date.toISOString().split(".")[0] + "Z";
      } catch (dateErr) {
        console.error("Error formatting date:", book.publishedDate, dateErr);
      }
    }
  });

  fs.writeFile(filePath, JSON.stringify(books, null, 4), "utf8", (writeErr) => {
    if (writeErr) {
      console.error("Error writing the file:", writeErr);
      return;
    }
    console.log("Published dates have been updated successfully.");
  });
});

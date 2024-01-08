// Dark/Light theme
// Set the initial theme to 'dark'
document.documentElement.setAttribute('data-bs-theme', 'dark');

// Get references to the HTML root element and the moon and sun icons
var htmlElement = document.documentElement;
var moonIcon = document.getElementById('moon-icon');
var sunIcon = document.getElementById('sun-icon');

// Initially hide the moon icon and show the sun icon
moonIcon.style.display = 'none';
sunIcon.style.display = 'block';

// Add a click event listener to the theme switcher button
document.getElementById('theme-switcher').addEventListener('click', function() {
    // If the current theme is 'dark'
    if (htmlElement.getAttribute('data-bs-theme') === 'dark') {
        // Switch to the 'light' theme
        htmlElement.setAttribute('data-bs-theme', 'light');
        // Show the moon icon and hide the sun icon
        moonIcon.style.display = 'block';
        sunIcon.style.display = 'none';
    } else {
        // Otherwise, switch to the 'dark' theme
        htmlElement.setAttribute('data-bs-theme', 'dark');
        // Hide the moon icon and show the sun icon
        moonIcon.style.display = 'none';
        sunIcon.style.display = 'block';
    }
});


//  Movies
// Wait until the document is ready
$(document).ready(function () {
    // Add a change event listener to the element with the id 'genre'
    $("#genre").change(function () {
        // Get the selected genre
        var genre = $(this).val();
  
        // Send a GET request to the server with the selected genre as a parameter
        fetch("http://localhost:8080/getMoviesByGenre?genre=" + genre, { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#movies")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["Titlu", "An", "Durata (min)", "Gen", "Studio", "Id Producator"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((movie) => {
                    const row = tbody.insertRow();
                    row.insertCell(0).innerHTML = movie.titlu;
                    row.insertCell(1).innerHTML = movie.an;
                    row.insertCell(2).innerHTML = movie.durata;
                    row.insertCell(3).innerHTML = movie.gen;
                    row.insertCell(4).innerHTML = movie.studioEntity.nume;
                    row.insertCell(5).innerHTML = movie.producator.id_persoana;
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  


//  Person
// Wait until the document is ready
$(document).ready(function () {
    // Add a click event listener to the button with the id 'submitBtn'
    $("#submitBtn").click(function () {
        // Get the value of the input field with the id 'minCastigNet'
        var minCastigNet = $("#minCastigNet").val();
  
        // Send a GET request to the server with the minimum net income and currency as parameters
        fetch("http://localhost:8080/getPersoanaByCastigNetAndMoneda?castig_net=" + minCastigNet + "&moneda=USD", { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#persoana")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["Id", "Nume", "Adresa", "Sex", "Data Nasterii", "Castig Net", "Moneda"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((persoana) => {
                    const row = tbody.insertRow();
                    row.insertCell(0).innerHTML = persoana.id_persoana;
                    row.insertCell(1).innerHTML = persoana.nume;
                    row.insertCell(2).innerHTML = persoana.adresa;
                    row.insertCell(3).innerHTML = persoana.gender;
                    row.insertCell(4).innerHTML = new Date(persoana.data).toLocaleDateString(); // Format the date
                    row.insertCell(5).innerHTML = persoana.castigNet;
                    row.insertCell(6).innerHTML = persoana.moneda;
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  

//   Studio & Producator
// Wait until the document is ready
$(document).ready(function () {
    // Add a click event listener to the button with the id 'submitBtn'
    $("#submitBtn").click(function () {
        // Get the values of the input fields with the ids 'title' and 'year'
        var title = $("#title").val();
        var year = $("#year").val();
  
        // Send a GET request to the server with the title and year as parameters
        fetch("http://localhost:8080/getFilmDetails?title=" + title + "&year=" + year, { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#film")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // If no data was returned, show a toast notification
                if (data.length === 0) {
                    var toastEl = document.getElementById("liveToast");
                    var toast = new bootstrap.Toast(toastEl);
                    toast.show();
                } else {
                    // Create the table head
                    const thead = table.createTHead();
                    const headerRow = thead.insertRow();
                    const headers = ["Titlu", "An", "Durata", "Gen", "Studio", "Adresa Studio", "Producator", "Adresa Producator", "Sex Producator", "Data Nasterii Producator", "Castig Net Producator", "Moneda Producator"];
                    headers.forEach((header) => {
                        const th = document.createElement("th");
                        th.textContent = header;
                        headerRow.appendChild(th);
                    });
  
                    // Create the table body
                    const tbody = table.createTBody();
                    data.forEach((film) => {
                        const row = tbody.insertRow();
                        row.insertCell(0).innerHTML = film.titlu;
                        row.insertCell(1).innerHTML = film.an;
                        row.insertCell(2).innerHTML = film.durata;
                        row.insertCell(3).innerHTML = film.gen;
                        row.insertCell(4).innerHTML = film.studioEntity.nume;
                        row.insertCell(5).innerHTML = film.studioEntity.adresa;
                        row.insertCell(6).innerHTML = film.producator.nume;
                        row.insertCell(7).innerHTML = film.producator.adresa;
                        row.insertCell(8).innerHTML = film.producator.gender;
                        row.insertCell(9).innerHTML = new Date(film.producator.data).toLocaleDateString(); 
                        row.insertCell(10).innerHTML = film.producator.castigNet;
                        row.insertCell(11).innerHTML = film.producator.moneda;
                    });
                }
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  
  


//   Actors
// Wait until the document is ready
$(document).ready(function () {
    // Add a click event listener to the button with the id 'getActorPairsBtn'
    $("#getActorPairsBtn").click(function () {
        // Log a message to the console
        console.log("Button clicked");
  
        // Send a GET request to the server
        fetch("http://localhost:8080/getActorPairs", { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#actorPairs")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["Actress Name", "Actress ID", "Actor Name", "Actor ID"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((pair) => {
                    const row = tbody.insertRow();
                    row.insertCell(0).innerHTML = pair[0];
                    row.insertCell(1).innerHTML = pair[1];
                    row.insertCell(2).innerHTML = pair[2];
                    row.insertCell(3).innerHTML = pair[3];
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  


//   Actress
// Wait until the HTML document is fully loaded
$(document).ready(function() {
    // Add a click event listener to the button with the id 'loadData'
    $("#loadData").click(function() {
        // Send a GET request to the server to fetch the least paid actress
        fetch("http://localhost:8080/getLeastPaidActress", { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#data")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["Name"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((item) => {
                    const row = tbody.insertRow();
                    row.insertCell(0).innerHTML = item;
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  


//  Movies 2
  // Wait until the HTML document is fully loaded
  $(document).ready(function () {
    // Add a click event listener to the button with the id 'compareBtn'
    $("#compareBtn").click(function () {
        // Get the values of the input fields with the ids 'compareTitle' and 'compareYear'
        var title = $("#compareTitle").val();
        var year = $("#compareYear").val();
  
        // Send a GET request to the server with the title and year as parameters
        fetch("http://localhost:8080/getMoviesWithGreaterDuration?title=" + title + "&year=" + year, { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#compare")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // If no data was returned, show a toast notification
                if (data.length === 0) {
                    var toastEl = document.getElementById("liveToast");
                    var toast = new bootstrap.Toast(toastEl);
                    toast.show();
                } else {
                    // Create the table head
                    const thead = table.createTHead();
                    const headerRow = thead.insertRow();
                    const headers = ["Titlu", "An", "Durata", "Gen", "Studio", "Id Producator"];
                    headers.forEach((header) => {
                        const th = document.createElement("th");
                        th.textContent = header;
                        headerRow.appendChild(th);
                    });
  
                    // Create the table body
                    const tbody = table.createTBody();
                    data.forEach((film) => {
                        const row = tbody.insertRow();
                        row.insertCell(0).innerHTML = film.titlu;
                        row.insertCell(1).innerHTML = film.an;
                        row.insertCell(2).innerHTML = film.durata;
                        row.insertCell(3).innerHTML = film.gen;
                        row.insertCell(4).innerHTML = film.studioEntity.nume;
                        row.insertCell(5).innerHTML = film.producator.id_persoana;
                    });
                }
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  


//   Producers
// Wait until the document is ready
$(document).ready(function() {
    // Add a change event listener to the element with the id 'genre2'
    $("#genre2").change(function() {
        // Get the selected genre
        var genre = this.value;
  
        // Send a GET request to the server with the selected genre as a parameter
        fetch("http://localhost:8080/getMoviesByGenre2?gen=" + genre, { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#movies")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["ID", "Name", "Numar filme"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((row) => {
                    const tr = tbody.insertRow();
                    row.forEach((cell) => {
                        const td = tr.insertCell();
                        td.textContent = cell;
                    });
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  

//   Studio Executive
// Studio Executive
// Wait until the HTML document is fully loaded
$(document).ready(function () {
    // Add a click event listener to the button with the id 'getMinMaxEarningsBtn'
    $("#getMinMaxEarningsBtn").click(function () {
        // Log a message to the console
        console.log("Button clicked");
  
        // Send a GET request to the server to fetch the minimum and maximum earnings
        fetch("http://localhost:8080/getMinMaxEarnings", { method: "GET" })
            .then((response) => response.json()) // Parse the response as JSON
            .then((data) => {
                // Get the table element
                const table = $("#earnings")[0];
  
                // Clear the table
                table.innerHTML = "";
  
                // Create the table head
                const thead = table.createTHead();
                const headerRow = thead.insertRow();
                const headers = ["Minim", "Maxim"];
                headers.forEach((header) => {
                    const th = document.createElement("th");
                    th.textContent = header;
                    headerRow.appendChild(th);
                });
  
                // Create the table body
                const tbody = table.createTBody();
                data.forEach((pair) => {
                    const row = tbody.insertRow();
                    row.insertCell(0).innerHTML = pair[0];
                    row.insertCell(1).innerHTML = pair[1];
                });
            })
            .catch((error) => console.error("Error:", error)); // Log any errors to the console
    });
  });
  

//   Exceptii
// Wait until the HTML document is fully loaded
$(document).ready(function() {
  // Add a click event listener to the button with the id 'loadExceptiiBtn'
  $("#loadExceptiiBtn").click(function() {
      // Send a GET request to the server to fetch the exceptions
      fetch("http://localhost:8080/exceptii", { method: "GET" })
          .then((response) => response.json()) // Parse the response as JSON
          .then((data) => {
              // Get the table element
              const table = $("#exceptiiTable")[0];

              // Clear the table
              table.innerHTML = "";

              // Create the table head
              const thead = table.createTHead();
              const headerRow = thead.insertRow();
              const headers = [
                  "Id Persoana",
                  "Nume",
                  "Adresa",
                  "Gender",
                  "Data",
                  "Castig Net",
                  "Moneda",
                  "Natura Exceptiei",
              ];
              headers.forEach((header) => {
                  const th = document.createElement("th");
                  th.textContent = header;
                  headerRow.appendChild(th);
              });

              // Create the table body
              const tbody = table.createTBody();
              data.forEach((item) => {
                  const row = tbody.insertRow();
                  row.insertCell(0).innerHTML = item.id_persoana;
                  row.insertCell(1).innerHTML = item.nume;
                  row.insertCell(2).innerHTML = item.adresa;
                  row.insertCell(3).innerHTML = item.gender;
                  row.insertCell(4).innerHTML = new Date(item.data).toLocaleDateString();
                  row.insertCell(5).innerHTML = item.castigNet;
                  row.insertCell(6).innerHTML = item.moneda;
                  row.insertCell(7).innerHTML = item.naturaExceptiei;
              });
          })
          .catch((error) => console.error("Error:", error)); // Log any errors to the console
  });
});

  
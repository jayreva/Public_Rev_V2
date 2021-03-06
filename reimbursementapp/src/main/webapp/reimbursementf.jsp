<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

    <style>
        .container {
            width: 50%;
            padding: 40px;
            border-radius: 30px;
            background: #191919;
            margin-bottom: 100px;
        }

        .container label {
            color: grey;
        }

        .container input,
        .container textarea,
        .container select {
            border: 2px solid #3498db;
        }

        .container button {
            border: 0;
            background: none;
            display: block;
            text-align: center;
            border: 2px solid #c9c613;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer
        }

        .container button:hover {
            background: #3498db
        }

        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: linear-gradient(to right, #81802b, #23538a)
                /* background-image: url('https://images.pond5.com/subtle-gradient-moving-shapes-background-footage-089496665_prevstill.jpeg'); */
        }

        .jumbotron {
            background: linear-gradient(to right, #81802b, #23538a)
                /* background-image: url('https://images.pond5.com/subtle-gradient-moving-shapes-background-footage-089496665_prevstill.jpeg'); */
        }

        .jumbotron p {
            color: black;
            font-weight: 500
        }

        .jumbotron h1 {
            color: black;
            font-weight: 500
        }

        nav {
            background-color: #191919;
        }

        .navbar a {
            color: #c9c613;
        }
        .navbar input {
            background-color: #191919;
            border: none;
        }
    </style>

</head>

<body>

    <!-- navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-warning" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Actions
                    </a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="navbarDropdown">
                        <form action="ViewTicketsServlet" method="POST">
                            <input type="submit" class="dropdown-item text-warning bg-dark" name="" value="Pending Tickets">
                        </form>
                        
                        <% int manager = (int)request.getAttribute("manager");
                        if (manager == 1) { %>
         					<form action="ViewAllTicketsServlet" method="POST">
                            <input type="submit" class="dropdown-item text-warning bg-dark" name="" value="All Tickets">
                        	</form>
      					<% } %>
      					
                    </div>        
                </li>

                <li class="nav-item">
                    <a class="nav-link text-warning" action="reimbursementf.jsp">Form</a>   
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="index.html">
                <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Logout</button>
            </form>
        </div>
    </nav>


    <!-- header -->
    <div class="jumbotron">
        <h1 class="display-6 text-white">Reimbursement Requests</h1>
        <p class="lead text-white">In the form below select what your reimbursement request is for as
            well as provide the
            reimbursement amount with a short description</p>
        <hr color="#fff">
    </div>


    <!-- main-content -->
    <div class="container">
        <h3 class="text-center text-light">Reimbursement Form</h3>
        <hr color="81802b">
        <form action="ReimbursementServlet" method="POST">
            <div class="form-group">
                <label for="reimbursementType">Select Reimbursement</label>
                <select class="form-control bg-dark text-light" name="ticketType" id="ticketType">
                    <option disabled hidden selected>--Select One--</option>
                    <option class="text-light" value="LODGING">LODGING</option>
                    <option class="text-light" value="TRAVEL">TRAVEL</option>
                    <option class="text-light" value="FOOD">FOOD</option>
                    <option class="text-light" value="OTHER">OTHER</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlInput1">Enter Reimbursement Amount</label>
                <input type="number" name="amount" id="amount" min="5" step="0.01" class="form-control bg-dark text-light" placeholder="$0.00">
            </div>

            <div class="form-group">
                <label for="exampleFormControlTextarea1">Please provide a short description of your expenses</label>
                <textarea class="form-control bg-dark text-light" name="description" id="description" rows="3"
                    placeholder="Example: I spent $57 for hotel lodging"></textarea>
            </div>
            <button type="submit" class="btn btn-outline-dark text-light">Submit</button>
        </form>
        <br>
    </div>


    <!-- footer -->
    <!-- <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Fluid jumbotron</h1>
            <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
        </div>
    </div> -->

</body>

</html>
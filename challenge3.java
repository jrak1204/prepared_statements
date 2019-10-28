//Example case

// dev notes: username and password need to be SQL injection protected. 
// googled best practice, is to use a prepared statement (making injection impossible)  

// bad
//String sql_query = "SELECT * FROM users WHERE userid ='"+ username + "'" + " AND password='" + Base64.getEncoder().encodeToString(passwordString.getBytes()) + "'";
//Statement stmt = connection.createStatement();
//ResultSet rs = stmt.executeQuery(query);

// good
String password = Base64.getEncoder().encodeToString(passwordString.getBytes());

PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
stmt.setString(1, username); // userid
stmt.setString(2, password);
ResultSet rs = stmt.executeQuery();
//End of example

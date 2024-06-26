try{
  Class.forName("com.mysql.cj.jdbc.Driver");

  String url = "jdbc:mysql://localhost:3306/khaisathi";
  
 Connection connection;
  connection = (Connection) DriverManager.getConnection(url, "root","");
 String sql = "SELECT * FROM login WHERE Username = ? AND Password = ?";
 
PreparedStatement statement;
  statement = (PreparedStatement) connection.prepareStatement(sql);
 statement.setString(1, users.getText());
 statement.setString(2, new String(password.getPassword()));

  ResultSet rs = statement.executeQuery();
  if(rs.next())
  {
    admin adminPage = new admin();
adminPage.show();
this.setVisible(false);
  }


 
}catch(ClassNotFoundException | SQLException e){System.out.print(e);
}
// adding data to the database
try {
  // Load the MySQL JDBC driver
  Class.forName("com.mysql.cj.jdbc.Driver");

  // Database URL, change according to your setup
  String url = "jdbc:mysql://localhost:3306/khaisathi";

  // Connect to the database
  Connection connection = DriverManager.getConnection(url, "root", "");

  // Retrieve the data from the text fields
  String Name = name.getText();
  String Phone = phone.getText();
  String ID = id.getText();
  String Address = address.getText();
  String ROOM = room.getText();

  // Prepare the SQL query
  String sql = "INSERT INTO members (`Name`, `Phone number`, `ID`, `Address`, `ROOM NO`) VALUES (?, ?, ?, ?, ?)";
  PreparedStatement statement = connection.prepareStatement(sql);
  statement.setString(1, Name);
  statement.setString(2, Phone);
  statement.setString(3, ID);
  statement.setString(4, Address);
  statement.setString(5, ROOM);

  // Execute the query
  statement.executeUpdate();

  // Close the statement and connection
  statement.close();
  connection.close();

} catch(ClassNotFoundException | SQLException e){System.out.print(e);}
<?php
require "conn.php";
$username = $_POST["username"];
$testtwo = $_POST["testtwo"];
$mysql_qry = "UPDATE user SET testtwo = '$testtwo' where username = '$username'";

if($conn->query($mysql_qry)===TRUE){
echo "Update Successful";
}
else {
echo "Update not successful. Error: ". $mysql_qry."<br>".$conn->error;
}
$conn->close();
?>
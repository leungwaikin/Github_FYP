<?php
require "conn.php";
$username = $_POST["username"];
$testsix = $_POST["testsix"];
$mysql_qry = "UPDATE user SET testsix = '$testsix' where username = '$username'";

if($conn->query($mysql_qry)===TRUE){
echo "Update Successful";
}
else {
echo "Update not successful. Error: ". $mysql_qry."<br>".$conn->error;
}
$conn->close();
?>
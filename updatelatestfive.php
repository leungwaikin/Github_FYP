<?php
require "conn.php";
$username = $_POST["username"];
$testfive = $_POST["testfive"];
$mysql_qry = "UPDATE user SET testfive = '$testfive' where username = '$username'";

if($conn->query($mysql_qry)===TRUE){
echo "Update Successful";
}
else {
echo "Update not successful. Error: ". $mysql_qry."<br>".$conn->error;
}
$conn->close();
?>
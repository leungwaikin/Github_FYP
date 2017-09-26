<?php
    require "conn.php";
    $username = "Tom"; 
    //fetch table rows from mysql db
    $sql = "select testone,testtwo,testthree,testfour,testfive,testsix from user where USERNAME = '$username'";
    $result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));

    //create an array
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);

    //close the db connection
    mysqli_close($conn);
?>
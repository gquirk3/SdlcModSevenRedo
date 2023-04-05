<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Main Page</title>
</head>
<body>
<h1>Simple To Do List</h1>
<br/>

<form name="myForm1" action="showList" method="post">

    <table>

        <tbody>


        </tbody>

    </table>

    <input type="submit" value="Display List" name="submit" />
</form>
<br/>
<br/>

<form name="myForm2" action="addItem" method="post">

    <table>

        <tbody>

        <tr>
            <td>Item to add:</td>
            <td><input type="text" name="add" value="" size="50" /></td>
        </tr>

        </tbody>

    </table>

    <input type="reset" value="Clear" name="clear" />
    <input type="submit" value="Submit" name="submit2" />
</form>
<br/>
<br/>

<form name="myForm3" action="removeItem" method="post">

    <table>

        <tbody>

        <tr>
            <td>Select item number to remove:</td>
            <td><input type="number" name="remove" value="" size="50" /></td>
        </tr>

        </tbody>

    </table>

    <input type="reset" value="Clear" name="clear2" />
    <input type="submit" value="Submit" name="submit3" />
</form>
<br/>
<br/>

<form name="myForm4" action="searchItem" method="post">

    <table>

        <tbody>

        <tr>
            <td>Enter item to search for:</td>
            <td><input type="text" name="search" value="" size="50" /></td>
        </tr>

        </tbody>

    </table>

    <input type="reset" value="Clear" name="clear3" />
    <input type="submit" value="Submit" name="submit4" />
</form>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生信息列表</title>
</head>
<body>
<div>学生信息:</div>
<#list studentList as item>
    ${item.sno}--${item.sname}--${item.bplace}
</#list>
</body>
</html>

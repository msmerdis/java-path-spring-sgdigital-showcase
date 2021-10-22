<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
    <@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="ourProducts"/>

<table>
	<tr>
		<th>#</th>
		<th>Serial</th>
		<th>Name</th>
		<th>Price</th>
		<th>Category</th>
	</tr>
    <#list products as product>
	<tr>
		<td>${product?counter}</td>
		<td>${product.serial}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td>${product.category.description}</td>
	</tr>
    </#list>
</table>

<@siteTemplate.footer/>
</body>

<#import "/spring.ftl" as spring />
<#import  "partial/siteTemplate.ftl" as siteTemplate>
<head>
	<@siteTemplate.importantLibraries/>
</head>
<body>
<@siteTemplate.navbar currentPage="about"/>
<p><@spring.message "owner.name"/></p>
<p><@spring.message "owner.food"/></p>
<p><@spring.message "owner.decision"/></p>
<@siteTemplate.footer/>
</body>

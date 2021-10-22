<html>
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

<p id="timesVisitedParagraph"></p>

<@siteTemplate.footer/>
</body>
<#-- Simple script which reads a "counter" cookie and replaces a paragraph with a text notifying the user about
the cookie (more specifically: the times he has visited the page) -->
<script>
	const cookieValue = getCookie("counter");
	document.getElementById("timesVisitedParagraph").textContent = "You have visited this page " + cookieValue + " " +
			"times!";

	// Function copied from the internet, basically access the wanted cookie
	function getCookie(name) {
		let cookie = {};
		document.cookie.split(';').forEach(function (el) {
			let [k, v] = el.split('=');
			cookie[k.trim()] = v;
		})
		return cookie[name];
	}
</script>
</html>

<%@page import="au.com.holden.web.forms.service.CashBackFormService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ taglib prefix="cs" uri="futuretense_cs/ftcs1_0.tld"
%><%@ taglib prefix="asset" uri="futuretense_cs/asset.tld"
%><%@ taglib prefix="assetset" uri="futuretense_cs/assetset.tld"
%><%@ taglib prefix="commercecontext" uri="futuretense_cs/commercecontext.tld"
%><%@ taglib prefix="ics" uri="futuretense_cs/ics.tld"
%><%@ taglib prefix="listobject" uri="futuretense_cs/listobject.tld"
%><%@ taglib prefix="render" uri="futuretense_cs/render.tld"
%><%@ taglib prefix="searchstate" uri="futuretense_cs/searchstate.tld"
%><%@ taglib prefix="siteplan" uri="futuretense_cs/siteplan.tld"
%><%@ page import="COM.FutureTense.Interfaces.*,
                   COM.FutureTense.Util.ftMessage,
                   COM.FutureTense.Util.ftErrors"
%><cs:ftcs><%-- HNZ User Generation Form

INPUT

OUTPUT

--%>
<%-- Record dependencies for the SiteEntry and the CSElement --%>
<ics:if condition='<%=ics.GetVar("seid")!=null%>'><ics:then><render:logdep cid='<%=ics.GetVar("seid")%>' c="SiteEntry"/></ics:then></ics:if>
<ics:if condition='<%=ics.GetVar("eid")!=null%>'><ics:then><render:logdep cid='<%=ics.GetVar("eid")%>' c="CSElement"/></ics:then></ics:if>

	<div class="jumbotron" style="margin-bottom: 0px;">
	  <div class="container">
	    <h1><%= ics.GetVar("title") %></h1>
	  </div>
	</div>
	<%
		if (ics.GetVar("navItems") != null && !ics.GetVar("navItems").isEmpty()) {
	%>
	<nav class="navbar navbar-default" role="navigation" >
		<div class="container">

			<a class="navbar-brand" href="http://preprod.holden.com.au/Satellite?pagename=Tools/Home"><span class="glyphicon glyphicon-home"></span></a>

			<ul class="nav navbar-nav navbar-left">
			<%
				for (String navItem : ics.GetVar("navItems").split(",")) {
					if (navItem != null && !navItem.isEmpty()) {
						String title = navItem.trim().split(":")[1];
						String requestTypeCode = navItem.trim().split(":")[0];
					
					
			%>
						<li><a href='<%= "#" + requestTypeCode %>'><%= title %></a></li>
			<%
					}
				}
			%>
			</ul>
		</div>
	</nav>
	<%
		}
	%>

</cs:ftcs>
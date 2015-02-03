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
<render:unknowndeps assettype="Form_C" />

<!DOCTYPE html>
<html lang="en">
<head>
	<render:callelement elementname="Tools/Common/HtmlHead" />
</head>
<%
	String navItems = "";
%>
<body>

	<render:callelement elementname="Tools/Common/HeaderNav"> 
		<render:argument name="title" value="HLD Tools" />
		<render:argument name="navItems" value='<%= navItems %>' />
	</render:callelement>

	<div class="container">

		<div  class="row">
			<div class="col-md-12">
				<h3>Ehcache</h3>
				<div class="list-group">
					<a href="/cs/tools/ehcache" class="list-group-item">View Cache Entries</a>
					<a href="/cs/tools/ehcache/clear?name=all" class="list-group-item" data-confirm="Are you sure you want to clear all Ehcache entries?">Clear All</a>
				</div>
				<h3>Forms</h3>
				<div class="list-group">
					<a href="/Satellite?pagename=Tools/Forms/Failed" class="list-group-item">View Failed Forms</a>
				</div>
				<h3>Page Configs</h3>
				<div class="list-group">
					<a href="/Satellite?pagename=Tools/Forms/Failed" class="list-group-item">View Page Configs</a>
					<a href="/cs/tools?ts=&command=reloadPageConfigs&siteId=1220581995574" data-confirm="Are you sure you want to clear all page configs for AU Desktop?" class="list-group-item">Reload AU Desktop</a>
					<a href="/cs/tools?ts=&command=reloadPageConfigs&siteId=1220634907311" data-confirm="Are you sure you want to clear all page configs for AU Mobile?" class="list-group-item">Reload AU Mobile</a>
					<a href="/cs/tools?ts=&command=reloadPageConfigs&siteId=1220633755581" data-confirm="Are you sure you want to clear all page configs for NZ Desktop?" class="list-group-item">Reload NZ Desktop</a>
					<a href="/cs/tools?ts=&command=reloadPageConfigs&siteId=1220643155321" data-confirm="Are you sure you want to clear all page configs for NZ Mobile?" class="list-group-item">Reload NZ Mobile</a>
					<a href="/cs/tools?ts=&command=reloadPageConfigs" data-confirm="Are you sure you want to clear all page configs for all sites?" class="list-group-item">Reload All Sites</a>
				</div>
				<h3>Accessories</h3>
				<div class="list-group">
					<a href="/Satellite?pagename=Tools/Accessories/view?siteId=1220581995574" class="list-group-item">View Accessories for AU</a>	
					<a href="/Satellite?pagename=Tools/Accessories/view?siteId=1220633755581" class="list-group-item">View Accessories for NZ</a>	
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>


</cs:ftcs>
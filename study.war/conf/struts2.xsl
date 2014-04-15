<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" encoding="iso-8859-15" 
            	version="1.0" omit-xml-declaration="yes"/>

  <xsl:template match="@*|node()[not(name()='struts1')]">
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="struts2">
    <xsl:apply-templates/>
  </xsl:template>
  
  <xsl:template match="struts1"/>

</xsl:stylesheet>
# Project structure

I refactored this from ant to maven. It uses the [Maven Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

Just run

    mvn verify

The `billpayevolution.war` will be created in `target`. Test results in `target/surefire-reports`.

I could not see which version the struts.jar in old ant version was. Here in maven I chose to use struts-1.3.10 (see pom.xml). It is **very** old and EOL, but good enough for compiling everything and create input for Sonargraph.

# Dependencys

[Sonargraph](https://www.hello2morrow.com/products/sonargraph) shows the cycles between packages `bill <-> financial` and `bill <-> audit` (green half circle on the right) that are in this 'InitialVersion'.

![](images/sonargraph-collapsed.png)

Other dependencys are fine:
* `ui` is top package that uses/sees other (lower) package `bill`
* `bill.data` is inner package of `bill` that is only used by outer package `bill`

Here we see who uses `data` package:

![](images/sonargraph-expanded-data-selected.png)

Here we see that the cycles between `bill <-> financial` and `bill <-> audit` are caused by class `Bill.java` in `bill`.

![](images/sonargraph-expanded.png)

# Artefact

Please note: All classes are bundled in one big war file (this is the old ant version)

    ~ git:(master) ✗ jar tf InitialVersion/deploy/billpay.war
    META-INF/
    META-INF/MANIFEST.MF
    WEB-INF/
    WEB-INF/web.xml
    BillDetail.jsp
    CustomerBills.jsp
    search.jsp
    WEB-INF/lib/
    WEB-INF/app.tld
    WEB-INF/lib/struts.jar        <<< WEB-INF/lib only contains struts.jar
    WEB-INF/struts-bean.tld
    WEB-INF/struts-config.xml
    WEB-INF/struts-form.tld
    WEB-INF/struts-html.tld
    WEB-INF/struts-logic.tld
    WEB-INF/struts-template.tld
    WEB-INF/struts.tld
    WEB-INF/classes/
    WEB-INF/classes/com/
    WEB-INF/classes/com/extensiblejava/
    WEB-INF/classes/com/extensiblejava/audit/
    WEB-INF/classes/com/extensiblejava/audit/AuditFacade.class
    WEB-INF/classes/com/extensiblejava/bill/          <<< all classes of package bill are included in war files classes folder
    WEB-INF/classes/com/extensiblejava/bill/data/
    WEB-INF/classes/com/extensiblejava/bill/test/
    WEB-INF/classes/com/extensiblejava/bill/Bill.class
    WEB-INF/classes/com/extensiblejava/bill/BillEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/Customer.class
    WEB-INF/classes/com/extensiblejava/bill/CustomerEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/DefaultBillEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/DefaultCustomerEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/Name.class
    WEB-INF/classes/com/extensiblejava/bill/data/BillDataBean.class
    WEB-INF/classes/com/extensiblejava/bill/data/BillDb.class
    WEB-INF/classes/com/extensiblejava/bill/data/CustomerDataBean.class
    WEB-INF/classes/com/extensiblejava/bill/test/AllTests.class
    WEB-INF/classes/com/extensiblejava/bill/test/BillDbTest.class
    WEB-INF/classes/com/extensiblejava/bill/test/BillTest.class
    WEB-INF/classes/com/extensiblejava/financial/
    WEB-INF/classes/com/extensiblejava/financial/Payment.class
    WEB-INF/classes/com/extensiblejava/ui/
    WEB-INF/classes/com/extensiblejava/ui/AuditAction.class
    WEB-INF/classes/com/extensiblejava/ui/BillDetailAction.class
    WEB-INF/classes/com/extensiblejava/ui/BillDetailForm.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchAction.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchForm.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchResultsBean.class
    WEB-INF/classes/com/extensiblejava/ui/PayAction.class

Here the new maven version. The output looks very similar to above (thank god!) while only using a minimal standard maven `pom.xml`. bye bye ant!
A lot of transitive dependencys from struts habe been added by default, maybe in a real project with real deployment one should edit this list and set some deps to provided or so. However, for this purpose here it is good enough.

    ➜ git:(master) ✗ jar tf target/billpayevolution.war | sort
    BillDetail.jsp
    CustomerBills.jsp
    META-INF/
    META-INF/MANIFEST.MF
    META-INF/maven/com.extensiblejava/billpayevolution/pom.properties
    META-INF/maven/com.extensiblejava/billpayevolution/pom.xml
    WEB-INF/
    WEB-INF/app.tld
    WEB-INF/classes/
    WEB-INF/classes/com/
    WEB-INF/classes/com/extensiblejava/
    WEB-INF/classes/com/extensiblejava/audit/
    WEB-INF/classes/com/extensiblejava/audit/AuditFacade.class
    WEB-INF/classes/com/extensiblejava/bill/
    WEB-INF/classes/com/extensiblejava/bill/Bill.class
    WEB-INF/classes/com/extensiblejava/bill/BillEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/Customer.class
    WEB-INF/classes/com/extensiblejava/bill/CustomerEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/DefaultBillEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/DefaultCustomerEntityLoader.class
    WEB-INF/classes/com/extensiblejava/bill/Name.class
    WEB-INF/classes/com/extensiblejava/bill/data/
    WEB-INF/classes/com/extensiblejava/bill/data/BillDataBean.class
    WEB-INF/classes/com/extensiblejava/bill/data/BillDb.class
    WEB-INF/classes/com/extensiblejava/bill/data/CustomerDataBean.class
    WEB-INF/classes/com/extensiblejava/financial/
    WEB-INF/classes/com/extensiblejava/financial/Payment.class
    WEB-INF/classes/com/extensiblejava/ui/
    WEB-INF/classes/com/extensiblejava/ui/AuditAction.class
    WEB-INF/classes/com/extensiblejava/ui/BillDetailAction.class
    WEB-INF/classes/com/extensiblejava/ui/BillDetailForm.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchAction.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchForm.class
    WEB-INF/classes/com/extensiblejava/ui/CustomerSearchResultsBean.class
    WEB-INF/classes/com/extensiblejava/ui/PayAction.class
    WEB-INF/lib/
    WEB-INF/lib/antlr-2.7.2.jar
    WEB-INF/lib/commons-beanutils-1.8.0.jar      << transitive dependencys of struts-1.3.10
    WEB-INF/lib/commons-chain-1.2.jar
    WEB-INF/lib/commons-digester-1.8.jar
    WEB-INF/lib/commons-logging-1.0.4.jar
    WEB-INF/lib/commons-validator-1.3.1.jar
    WEB-INF/lib/oro-2.0.8.jar
    WEB-INF/lib/servlet-api-2.5.jar
    WEB-INF/lib/struts-core-1.3.10.jar
    WEB-INF/struts-bean.tld
    WEB-INF/struts-config.xml
    WEB-INF/struts-form.tld
    WEB-INF/struts-html.tld
    WEB-INF/struts-logic.tld
    WEB-INF/struts-template.tld
    WEB-INF/struts.tld
    WEB-INF/web.xml
    search.jsp

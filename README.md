# Zanim zaczniemy:
https://stackoverflow.com/questions/60127591/apache-karaf-4-2-6-shell-unable-to-install-webconsole

# Teoria

* Developers Guide: http://servicemix.apache.org/docs/7.x/developers-guide/index.html

* UserGuide: http://servicemix.apache.org/docs/7.x/users-guide/index.html

* Feature - zestaw bundli OSGI definiujących aplikację. 

* Bundle - jednostka deploymentu na szynie ESB

Przykład: 
Definicja URL:
<bundle>http://repo1.maven.org/maven2/org/apache/servicemix/nmr/org.apache.servicemix.nmr.api/1.0.0-m2/org.apache.servicemix.nmr.api-1.0.0-m2.jar</bundle>
Definicja MVN:
<bundle>mvn:org.apache.servicemix.nmr/org.apache.servicemix.nmr.api/1.0.0-m2</bundle>

* Bundle 'dependency'
Oznaczenie Bundle'a mówiące, ze jest to zależność dla innego. Podobny mechanizm istnieje w featurach (Dependent features) - przydatne w przypadku mechanizmu resolverów, które pobierają listę zależnych bundli.

* Jaas - Java Authentication and Authorization Service
https://docs.huihoo.com/fuse/esb/4.4/esb_security/SecureBroker-JAASOverview.html

* admin 
https://servicemix.apache.org/docs/7.x/users-guide/child-instances.html

* config - umożliwia edytowanie konfiguracji w Runtime

* log - obsługa loggera

* deployer - odpowiedzialny za deployment plików konfiguracyjnych:
http://servicemix.apache.org/docs/7.x/users-guide/deployer.html


## Pozostałe: 
* Remote access: http://servicemix.apache.org/docs/7.x/users-guide/remote-console.html

* JAAS - Java Authentication and Authorization Service 
(JAAS) https://docs.oracle.com/en/java/javase/11/security/java-authentication-and-authorization-service-jaas1.html

https://servicemix.apache.org/docs/7.x/users-guide/security.html
http://servicemix.apache.org/docs/7.x/users-guide/failover.html

* JBI (Java Business Integration). Specyfikacja opisująca sposób łączenia ze sobą komponentów
  integracji, takich jak np. usługi magistrali ESB, w sposób niezależny od dostawców i zapewniający przenośność.

* JCA (J2EE Connector Architecture). Specyfikacja definiująca sposób użycia standardowego
  zestawu kontraktów interfejsów do tworzenia adapterów, które zostaną podłączone do
  aplikacji korporacyjnych, a ponadto umożliwią interakcję z nimi.

* JMX (Java Management eXtensions). Specyfikacja zarządzania zdalnego, która definiuje
  środki umożliwiające aplikacji współpracę z infrastrukturą i konsolami zarządzania.

* wzorzec VETO (Validate, Enrich, Transform, Operate)

* SMX -> lack of cloud deployment!
https://softjourn.com/blog/article/do-esb-s-still-play-a-role

* Developer commands:
http://servicemix.apache.org/docs/7.x/developers-guide/developer-commands.html

* How to connect to karaf console?
http://servicemix.apache.org/docs/7.x/developers-guide/connect-console.html

* Custom bundle
http://servicemix.apache.org/docs/7.x/developers-guide/creating-bundles.html

* Fabric 8
http://fabric8.io/

# Konfiguracja (sprawdźmy)

* jre.properties - kalibracja pakietów JRE per wersja Javy - niektóre biblioteki (apache) nadpisują pakiety dostarczane przez w JRE.
http://servicemix.apache.org/docs/5.x/users-guide/jre-tuning.html
* keys.properties - konfiguracaja kluczy i ról użytkowników SMX
https://access.redhat.com/documentation/en-us/red_hat_jboss_fuse/6.2.1/html-single/configuring_and_running_jboss_fuse/index
* org.apache.activemq.server-default.cfg - konfiguracja serwera amq.
* org.apache.activemq.webconsole.cfg - konfiguracja webconsoli amq.
* org.apache.aries.transaction.cfg - konfiguracja pluginów ariesa dotyczących obsługi transakcji.
* org.apache.karaf.command.acl.feature.cfg - konfiguracja uprawnień dla operacji na featurach per grupa.
* org.apache.karaf.command.acl.jaas.cfg - konfiguracja uprawnień dla jaas per grupa.
* org.apache.karaf.features.cfg - ważny plik zawierający konfigurację repozytoriów z feature filami.
* org.apache.karaf.features.repos.cfg - konfiguracja aliasów na repozytoria.
* org.apache.karaf.jaas.cfg - konfiguracja szyfrowania haseł.
* org.apache.karaf.management.cfg - zarzązanie karafem (między innymi security).
* org.apache.karaf.shell.cfg - ssh shella, welcomeBanner, poziomy logowania.
* org.ops4j.pax.logging.cfg - konfiguracja logowania szyny.
* overrides.properties - plik z konfiguracją nadpisującą starą konfigurację.
* users.properties - definicja użytkowników i ich ról
* activemq.xml - konfiguracja activemq.
* config.properties - ważne zmiany konfiguracyjne SMX.
* custom.properties -> nadpisuje config.properties.

# Rozgrzewka + teoria:
0. ServiceMix dev commands:
http://servicemix.apache.org/docs/7.x/commands/dev-restart.html#

1. Webconsole
a) Instalujemy feature webconsoli:

karaf@root> feature:install webconsole

b) Weryfikujemy instalację:

karaf@root> feature:list | grep webconsole

c) Wchodzimy na stronę:

http://localhost:8181/system/console/features

2. Apache Felix Maven Bundle Plugin
Apache Felix - Osgi Implementation
http://felix.apache.org/documentation/subprojects/apache-felix-maven-bundle-plugin-bnd.html

3. Apache Geronimo
http://geronimo.apache.org/

4. Apache Camel
http://servicemix.apache.org/docs/7.x/camel/index.html

5. Apache Karaf

Karaf - moduł, który dostarcza możliości konfiguracji, deploymentu w runtimie frameworków takich jak spring boot, web. Bazuje na featerach, wspiera:
* hot deployment
* dynamiczną konfigurację
* system logowania
* provisioning
* rozszerzoną shell consolę
* zdalny dostep po ssh
* konfigurację Security & ACL na podstawie JAAS z użyciem RBAC
* zarządzanie instancjami
* featury enterprise: JDBC, JPA, JTA, JMS
* REST -> support dla CXFa
* współpraca z zewnętrznymi serwisami (Camel)

Provisioning: https://karaf.apache.org/manual/latest/provisioning
Biblioteka: http://karaf.apache.org/
SMX Guide dla Karafa: http://servicemix.apache.org/docs/7.x/users-guide/start-stop.html

6. Activiti
http://servicemix.apache.org/docs/7.x/activiti/activiti-camel-example.html

7. Apache CXF

Apache CXF to platforma do tworzenia usług internetowych, 
której można używać do tworzenia usług sieciowych SOAP i Rest. 
CXF jest w pełni zgodny ze standardami JAX-RS and JAX-WS.

http://cxf.apache.org/
http://cxf.apache.org/docs/cxf-architecture.html

8. ActiveMQ

https://activemq.apache.org/

9. Apache Aries

Projekt zawiera pluginy napisanie w Javie uruchamiające model OSGI. 
http://aries.apache.org/documentation/index.html

10. SOAP

(ang. Simple Object Access Protocol)

Istnieją dwa podejścia do tworzenia usług sieciowych SOAP -

* Code first - W tym podejściu WSDL jest generowany z kodu.
* Contract first - W umowie najpierw kod jest generowany z WSDL.

11. Debug mode
http://servicemix.apache.org/docs/7.x/developers-guide/debugging.html

12. ACL - Access Contol List - lista kontroli dostępu
https://en.wikipedia.org/wiki/Access-control_list

# Praktyka czyni mistrza

## Zadanie 1
Run Servicemix + setup banner + create user

## Zadanie 2
Uruchom servicemix z debug mode

## Zadanie 3
Uruchom webconsole (howtio)

## Zadanie 4
Zapoznaj się z prostymi przykładowymi aplikacjami

## Zadanie 5
Zrób własny feature file na bundle i zaprojektuj aplikację, 
która księguje zamówienia na podstawie 3 źródeł:
1) SOAP
2) REST
3) Podrzucony plik

Aplikacja powinna wykorzystywać activemq do komunikacji.
Aplikacja powinna się składać z conajmniej 5 bundli.

# Dockerfile*

Podejście do deploymentu dockerowego

docker run -d -t \
--name servicemix \
-p 1099:1099 \
-p 8101:8101 \
-p 8181:8181 \
-p 61616:61616 \
-p 36888:36888 \
-p 44444:44444 \
-v /host/path/deploy:/deploy \
merbel/servicemix
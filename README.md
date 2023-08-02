# retten
<img height="150px" width="250px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Logo_HTW_Berlin.svg/2000px-Logo_HTW_Berlin.svg.png"/>

<div align="center">
        <center>
        
# Retten


### Projekt Softwareentwicklung - WiSe 18/19 

HTW Berlin








</center>
</div>




#### Inhaltsverzeichnis

1. [Einführung](#introduction)

   1. [Abstrakt](#Abstrakt)
   2. [Produktidee](#Produktidee)
   3. [Ziele](#Ziele)

2. [Produktmodelle](#Modellierung)
   1. [Datenbank](#db)
   2. [Zustandsdiagramm](#ZustandDiagramm)
   3. [Widgets](#Widgets)
   4. [Programme](#Programm)
3. [Implementierung der Anwendung](#db)
   1. [Implementierung der Datenbank in Firebase](#dbFirebase)
   2. [Datenbank in Android Studio](#dbAndroidStudio)
   3. [Design](#Design)
   4. [Testing](#Test)
       
4. [Zusammenfassung](#Fazit)



## 1. Einführung <a name="introduction"></a>


<a href="https://imgur.com/hZDUXt6"><img src="https://i.imgur.com/hZDUXt6.jpg" title="source: imgur.com" /></a>

![Logo App]


1. [Abstrakt](#Abstrakt)


Für unser Projekt im Rahmen der Veranstaltung Softwareentwicklung im Wintersemester 18/19 haben wir nach Ideen gesucht und geguckt wie wir eine gesellschaftliche Aufgabe übernehmen können. Nach und nach hat sich herausgestellt, dass wir einen kleinen Beitrag leisten wollen. Diese Aufgabe soll interessant für die Nutzer sein und uns vielleicht einen wirtschaftlichen Gewinn erzielen. Somit haben wir uns entschieden Lebensmitteln zu retten.  Diese Anwendung soll der Name Retten haben und ist die Dienstleistung, die wir präsentieren wollen. Wir haben für uns ein akutes Problem in der Gesellschaft, die immer dazu neigt mehr und mehr zu konsumieren,entdeckt. Deswegen dachten wir uns, dass das Konzumentverhalten möglichst reguliert werden sollte. Aufgrund der höheren Nutzerzahl von Handys oder Smartphones sollte eine fähige Anwendung auf dem Telefon von größer Hilfe sein. Diese würde der Nutzer dazu bringen Angebote von Supermärkte zu finden und diese noch in kürzer Zeit verwenden können. Wie das alles geschehen soll, wollen wir in den nächsten Schritte aufzeigen.     


2. [Produktidee](#Produktidee)


Unser Produkt soll helfen zu verhindern, dass Lebensmitteln weggeschmissen werden, welche noch Verwendung finden können. Bei der höheren Anzahl an Produkten mit Haltbarkeitsdaten hat der Nutzer keinen Überblick mehr. Denn es gibt viele Produkte, die laut den Daten nicht zur Verwendung kommen dürfen aber wiederrum noch im guten Zustand sich befinden. Alleine in Deutschland und auch in vielen anderen Ländern landen noch intakte Produkte auf dem Müll. Auf der ganzen Welt werden rund 1,3 Milliarden Tonnen Lebensmittel jährlich entsorgt. Siehe dazu  https://www.wwf.de/themen-projekte/landwirtschaft/ernaehrung-konsum/verschwendung/ und  https://www.bzfe.de/inhalt/lebensmittelverschwendung-1868.html. Um diesen Trend zumindest marginal entgegenzuwirken, wollen wir die App „retten“ entwickeln.
Mit unserer Applikation kann ein Supermarkt Produkte verkaufen, die er normalerweise entsorgen müsste. Die Kunden können Mithilfe der Applikation Produkte günstiger erwerben und direkt bei ihrem Supermarkt in der Nähe abholen. Die Supermärkte bieten die Produkte, die eigentlich aus dem Sortiment entfernt werden sollten, zu einem billigeren Preis an. Die Applikation versucht hierbei, möglichst einfach und schnell zwischen Kunde und Supermarkt zu vermitteln und den Gebrauch für beide Seiten so einfach wie möglich zu gestalten. Diese Anwendung sollte die Schnittstelle zwischen beide Parteien sein und somit einen günstigeren Austausch ermöglichen. 


3. [Ziele](#Ziele) 


Die Erstellung eines Pflichtenheft sowie Lastenheft in Rahmen eines Softwareprojekts ist von größer Bedeutung, um die Anforderung einer Applikation am Anfang definieren zu können. Diese würden dazu beitragen eine klare Sicht der Organisatiion und auch die Anforderungen unsere Software zu unterteilen. Deswegen haben wir grobe Ziele definiert. 
Zu Beginn des Projektes wurden verschiedene Soll- sowie Kann-Ziele determiniert, welche im Folgenden näher erläutert werden:
```
  Soll-Ziele:```
 
1. Die App soll zwei Benutzerprofile haben – den Supermarkt und den Kunden. Beide Benutzertypen haben unterschiedliche Views zur Verfügung und können somit verschiedene Aktivitäten ausführen.
2. Die Kunden sollen nach Märkten oder direkt nach Produkten suchen können.
3. Der Warenkorb soll verschiedene Zahlungsmöglichkeiten bieten und eine Übersicht sowohl über die Produkte als auch über den Warenwert geben.
4. Alle Produkte müssen nach Kategorien sortiert sein und gewisse Informationen wie beispielsweise Haltbarkeitsdatum und Preis enthalten.
5. Supermärkte müssen Produkte hinzufügen und löschen können.
6. Kunden müssen Produkte suchen finden und reservieren können.

```
  Kann-Ziele:```

1. Es kann eine Karte entwickelt werden, auf welcher der aktuelle Standort angezeigt wird sowie die darum liegenden Märkte. Somit wird die Suche nach dem nächstgelegenen Markt erleichtert. 
2. Es kann einen Barcodescanner geben, mit dessen Hilfe die Produkte leichter der Produktliste hinzugefügt werden können.
3. Es kann eine Möglichkeit implementiert werden, mit welcher die Kaufabwicklung beim Supermarkt vereinfacht wird. Ein Beispiel hierfür ist ein generierter QR-Code, welcher auf einen bestimmten Warenkorb referenziert.

Zum Schluss in der Zusammenfassung wird näher auf den Erfolg sowie den Abschluss der Soll- und Kann-Ziele eingegangen.
 

## 2. Produktmodelle <a name="Produktmodelle"></a>


In dem Punkt Produktmodelle wird näher auf die Planung der Datenbank und den Ablauf unserer Screens eingegangen. Als Erstes wird der Punkt „Datenbank“ näher diskutiert und über der konzeptionelle und relationale Datenbankentwurf erläutert. 
.....


1. [Datenbank](#db)


<a href="https://imgur.com/eSOT5mS"><img src="https://i.imgur.com/eSOT5mS.jpg" title="source: imgur.com" /></a>

![Datenbank]


In dieser Graphik hat man die Vision definiert wie einzelnen Komponenten und zwar mit welchen Eigenschaften auszusehen haben. Sowohl Supermärkte als auch Kunden besitzen Grundelemente, die deren Funktionen erläutern. Hiermit zeichen wir auf wie verschiedene Module miteinander kommunizieren.  


 2. [Zustandsdiagramm](#ZustandDiagramm)


In folgendem Zustandsdiagramm auf Bild  wird der Ablauf unserer App verdeutlicht.


<a href="https://imgur.com/dbI6BT8"><img src="https://i.imgur.com/dbI6BT8.jpg" title="source: imgur.com" /></a>

![Zustandsdiagramm]

Wie schon oben erwähnt, sollte der Unterschied zwischen Supermarkt und Kunde schon bei der Registrierung aufgezeigt werden. Somit ist beim ersten Öffnen eine Startseite mit der Option einer Anmeldung oder Registrierung angezeigt werden. Dort kann sich der Kunde registrieren. Ein neuer Supermarkt kann nur von einem Admin erstellt werden, um zu verhindern, dass sich Privatpersonen als Supermarkt ausgeben. Dies ist der Fall, weil der Supermarkt mehrere Optionen anbieten kann. Ist eine Anmeldung erfolgt, wird der jeweilige nutzerspezifische Homescreen aufgerufen. 
Als Kunde steht die Auswahl zwischen Märkten und Produkten aus.
 Bei den Märkten werden die einzelnen Symbole angezeigt, woraufhin einer dieser ausgewählt werden kann. Jeder Markt besitzt eine eigene Liste mit den angebotenen Produkten. Zeitgleich kann auch direkt nach Produkten gesucht werden. Die Produkte sind in bestimmte Kategorien unterteilt und werden dann in einer Liste angezeigt.
In der Produktliste können Produkte dem eigenen Warenkorb hinzugefügt und somit ein oder mehrere Produkte erwerben. Dieser Vorgang wird abgeschlossen  und Mithilfe eines Bezahlverfahrens und eines generierten QR-Codes direkt beim jeweiligen Markt abgeholt werden. Das generierte QR-Code hilft den Supermarkt zu sehen, welche Produkte ausgewählt sind und somit das Kaufverfahren bei der Abholung der Ware bestätigen zu können. In jeder der Schritte kann Mithilfe der Zurücktaste zur vorherigen Aktion zurückgekehrt werden, falls Fehler eingeglichen sind oder der Kunde das Kaufverfahren abrechen wollen würde. 

Als Supermarkt kann in der Produktliste ein neues Produkt hinzugefügt oder entfernt werden, je nach dem ob das Produkt zur Verfügung gestellt werden kann oder nicht. Außerdem können reservierte Produkte eingesehen und nach ihrem Bezahlstatus überprüft werden. Damit haben die Supermärkte einen Überblick über die laufenden Einzelnheiten und können zeitnah auf Veränderungen reagieren und alles noch kontrollieren. 
Der Admin kann Supermärkte hinzufügen oder Informationen über die Märkte ändern und löschen. Mit der Lösung ist die Regulierung der Aktivitäten der Supermärkten gewährleistet.


3. [Widgets](#Widgets)


<a href="https://imgur.com/XbYl2hR"><img src="https://i.imgur.com/XbYl2hR.jpg" title="source: imgur.com" /></a>

![Anmeldung Profile] 

Das Login ist der erste Eindruck, den der Nutzer oder der Supermarkt zusehen bekommt. Hier soll jeder für sich die primären Informationen ausfüllen und diese speichern. 
Der Entwurf der Widgets legt, wie auch in den Zielen festgelegt, zwei verschiedene Sichten fest.

<a href="https://imgur.com/vBKc0Qz"><img src="https://i.imgur.com/vBKc0Qz.jpg" title="source: imgur.com" /></a>

![Supermärkte in der Datenbanken mit Kontaktdaten]

 Die erste Sicht, in Bild zu sehen, ist die eines Supermarktes. Dieser hat Links eine Anmeldeseite. Auf der nächsten Seite ist eine Auswahl zu erkennen, welche bereits im Zustandsdiagramm gezeigt wurde. Hier kann der Supermarkt eine Liste einsehen und Mithilfe dieser neue Produkte hinzufügen oder löschen. Diese Liste ist exemplarisch auf dem Panaromabild gezeigt. Das Löschen ist mit der Checkboxfunktion vereinfacht. Jedes Produkt kann zudem erweitert werden, um nähere Informationen zu erhalten. Im zweiten Auswahlpunkt, den reservierten Produkten, kann der Supermarkt die Kunden mit den jeweiligen Produktlisten einsehen. Diese Liste kann auf die nächste Sicht gesehen werden. Unter Zuhilfenahme dieser Listen können somit die Produkte verpackt und abholfertig für den Kunden vorbereitet werden. Auch der Bezahlstatus kann dieser Liste entnommen werden. Hier folgend sind die vier Schritte als zusammengefasste Panaroma zu sehen.

<a href="https://imgur.com/0v6PPnz"><img src="https://i.imgur.com/0v6PPnz.jpg" title="source: imgur.com" /></a>

![Panaroma Supermarktsicht]

Auf dem folgen Panaroma-Bild wird die Sicht des Kunden dargestellt. Genauso wie beim Supermarkt gibt es auch hier die Anmeldung erforderlich. Auf der zweiten Sicht gibt es wieder eine Auswahl, mit dessen Hilfe zwischen einer Produktsuche nach Märkten und nach Produkten unterschieden wird. Auf der Märktesicht sind die verschiedenen Symbole der Märkte dargestellt. Jedes Symbol kann erweitert werden, um mehr Informationen, wie die Adresse oder Öffnungszeiten, preis zu geben. Unter dem Punkt „Produkte“ können die Waren nach Kategorien sortiert und Mithilfe von Checkboxen in den Einkaufskorb gelegt werden. Im Einkaufskorb kann zwischen einer Bar- und einer Kartenzahlung gewählt werden. Hier unter sehen wir wie die einzelnen Schritte erfolgen. 


<a href="https://imgur.com/qiuIfQu"><img src="https://i.imgur.com/qiuIfQu.jpg" title="source: imgur.com" /></a>

![Panaroma Kundensicht]


4. [Programme](#Programm)


Im Rahmen des Projekts haben wir verschiedene Tools genutzt. 

Mithilfe des Programms „UMLET“ wurden Bilder, die dem Entwurf der Datenbank dient, erstellt. Das Programm bietet die schnelle und einfache Möglichkeit, konzeptionelle und relationale Datenbankmodelle zu erstellen, sowie den Entwurf von Zustandsdiagrammen. „UMLET“ funktioniert mit einem Drag&Drop System und ein paar einfachen Kommandos innerhalb der Vorlagen. Mit jeweils vor und nach dem Wort eingefügten Unterstrichen, kann dieses unterstrichen eingetragen werden. Mit dem Schlüsselwort „bg=“ kann die Hintergrundfarbe geändert werden, um lediglich einige Beispiele zu nennen.
 Für die Kommunikation zwischen einzelne Teammitglieder haben wir Slack als zentrale Dienst für die Organisation damit wir Aufgaben dort erledigen können. Ein sogenannter Workspace wurde dort erstellt und alle Teammiglieder haben dort kommuniziert. 
Hinzu kommt, dass wir ein Git-Repository erstellt haben wo die Teammitglieder verschiedene Versionen deren persönlichen Arbeit hochgeladen haben. Damit konnten die anderen die Versionen der Software herunterladen und Änderungen anpassen. Diese Plattform eignen sich für vieles mehr. Aber einige Teammitglieder hatten Schwierigkeiten damit zu arbeiten. Deswegen dürften nur einige von uns Änderungen, je nach Bereiche, vornehmen. Nicht zu vergessen sind die Dienste der Website imgur um Bilder hochzuladen, um diese später ins Htmldokument der Belegarbeit hinzuzufügen. Imgur ist als Workloadspace, was für jeden kostenlos verfügbar ist.   
Die zusätzliche Werkzeuge, die wir bei der Implementierung benutzt haben, werden in folgenden Zeilen näher erläutert. 



## 3.Implementierung der Anwendung <a name="#db"></a>


Bei der Wahl der Technologie haben wir uns für die Tool-Suite „Firebase“ von Google entschieden. Diese beinhaltet umfangreiche Funktionalitäten. Am Anfang hatten wir überlegt die Datenbank ,,Open Food Facts" miteinzubinden damit wir schon eine umfangreiche Liste von Produkten mit einer detaillierten Beschreibung verfügen können. Leider war es schwierig die Json-Files in die Androiddatenbank zu implementieren. Firebase war die plausible Lösung für die Implementierung der Datenbank. Die Option Kamera müsste aktiviert werden damit wir die generierte QR-Code scannen können. Android Studio verfügt über verschiedene Dienste, wie wir das zusammen einbinden können. Diese werden  wir demnächst erläutern.


1. [Implementierung der Datenbank in Firebase](#dbFirebase)


Für die Datenbank wird die „Realtime Database“ genutzt. Damit ist es möglich sehr effizient zu entwickeln und es wird dem Programmierer viel Konfiguration abgenommen. Außerdem ist sichergestellt, dass diese Technologie fehlerfrei funktioniert und auch unter hohen Belastungen standhält. Es muss kein Server initialisiert werden. Daten werden in der Cloud gespeichert. Es handelt sich um eine nicht relationale Datenbank (NoSQL). Einer der Hauptgründe für die Wahl dieser Technologie sind die Synchronisationsmechanismen in Echtzeit. Sogenannte Event-Listener überprüfen dauerhaft ob sich Daten geändert haben. Jedes Gerät welches mit dieser Datenbank verbunden ist aktualisiert sich automatisch. Somit werden keine komplizierten Netzwerkbibliotheken benötigt. Ein weiterer Vorteil ist das garantierte Funktionieren der Applikation bei Verbindungsunterbrechungen des Gerätes mit dem Internet. Der aktuelle Zustand der Datenbank wird lokal auf dem Gerät gespeichert. Auf diesen Datenbestand wird zugegriffen, wenn die Datenbank in der Cloud nicht erreichbar ist. Sobald die Internetverbindung wieder aufgebaut wird erhält der Klient den aktuellen Datenbestand.
Im Gegensatz zu SQL-Datenbanken werden keine Tabellen und Relationen verwendet. Alle Daten sind JSON-Objekte. Beim Hinzufügen eines Objektes wird ein neuer Knoten in diesem Baum erzeugt. Jeder Knoten ist eindeutig durch einen Schlüssel identifizierbar. Das Datenbankmodell mit seinen Entitäten wird in Java-Klassen umgesetzt. Jede Entität entspricht eine Klasse mit Attributen. Attribute ergeben Kind-Knoten mit einem Schlüssel – Werte Paar. So ergibt sich eine Verschachtelung mit mehreren Ebenen. Beim Entwurf wurde darauf geachtet, dass die Verschachtelung eine geringe Anzahl von Ebenen, eine geringe Tiefe aufweist. Die Methoden sind nicht von Relevanz. Dazu wird im Projektverzeichnis ein neuer Ordner ‚database‘ angelegt. Dort entspricht jede Datei einer Java Klasse. Es wurden die Klassen  ‚Supermarkt‘ und ‚Produkt‘ angelegt. Die Attribute der Klassen wie z.B. ‚Marktname‘ oder ‚Öffnungszeit‘ entsprechen Einträge in den JSON-Objekten. Beim Erzeugen eines Objektes wird ein Knoten in der JSON-Baumstruktur angelegt. 


2. [Datenbank in Android Studio](#dbAndroidStudio)


Im Android-Studio ist Firebase bereits installiert. Es muss dem Projekt als Abhängigkeit hinzugefügt werden. Dazu wird in der build.gradle Datei ein entsprechender Eintrag im ‚dependency‘ Codeabschnitt eingefügt.

```java

implementation 'com.google.firebase:firebase-database:16.0.5'
```

Dabei ist die Versionsnummer zu beachten. Diese muss mit den anderen übereinstimmen, sonst ist das Projekt nicht kompilierbar. Beim Start der App wird die Datenbank initialisiert. Dazu wird eine Instanz erzeugt und dann die Referenz in einer Variablen gespeichert.

```java

private DatabaseReference mDatabase;

mDatabase = FirebaseDatabase.getInstance().getReference();
```java

Diese Referenz wird verwendet, wenn Daten in die Datenbank geschrieben werden. Um Daten auf Veränderung zu überprüfen und daraufhin den Zustand der Applikation entsprechend zu aktualisieren werden asynchrone Listener an die Referenz übergeben. Das ist zum Beispiel die periodische Dekrementierung des Ablaufdatums.  Der Listener wird am Anfang und bei Veränderung der zu überwachenden Daten aufgerufen. Wegen der Veränderung des Ablaufdatums ändert sich die Anzeige auf der Oberfläche, dem TextView. Der Benutzer weiß sofort Bescheid. Für das Hinzufügen von ‚Supermarkt‘ und ‚Produkt‘ wird jeweils eine eigene Activity angelegt. In diesen Activities befinden sich lokale Referenzen auf die Firebase Datenbank. Außerdem wird eine Liste mit ‚Supermarkt‘ bzw. ‚Produkt‘ Objekten angelegt. Beim Hinzufügen von Produkt Objekten werden diese in eine in eine ‚ShoppingItem‘ Wrapper Klasse gespeichert. EditText Boxen erhalten Input vom Benutzer und beim Klick auf ‚Hinzufügen‘ wird ein neues Objekt an diese Liste angehängt.

```java
ArrayList<ShoppingItem> productList = new ArrayList<>();

productList.add(new ShoppingItem(productid.getText().toString()…));

```

Dann wird die Liste von ‚Produkt‘ Objekten in eine HashMap eingelesen um damit in der Datenbank eine Struktur zu erzeugen. Die Datenbank wird mit updateChildren() aktualisiert. Mit dieser Funktion wird auch sichergestellt, dass keine bereits existierenden Einträge überschrieben werden. Es wird ein Wurzel(root)-Knoten mit der Bezeichnung ‚products‘ erstellt. Die ‚productList‘ wird in einzelne Einträge unter diesem Wurzel-Knoten übersetzt. ‚Produkt‘ JSON Objekte sind Schlüßel-Werte Paaren, die die Attribute mit aktuellen Werten enthalten.

```java

Map<String, Object> cartItemsMap = new HashMap<>();
cartItemsMap.put("products", productList);
mDatabase.updateChildren(cartItemsMap);

```

Um das Lesen zu implementieren wird ein ‚ValueEventListener‘ für die Datenbank Referenz erzeugt. Wenn sich ein Wert ändert wird eine Callback-Methode OnDataChange() aufgerufen. Es wird ein Snapshot erstellt, der den Zustand der Datenbank zum Zeitpunkt der Wertänderung enthält.

```java

mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        IndividualProduct.this.dataSnapshot = dataSnapshot;
    }
});

```

Aus diesem Snapshot können Werte gelesen werden. Dazu wird der entsprechende Schlüßel angegeben. Hauptsächlich werden Produkte gelesen, die von Supermärkten hinzugefügt wurden. Diese Produkte werden den Benutzern in der App angezeigt. Es ist oft notwendig gelesene Werte in geeignete Variablen-Typen umzuwandeln. Zahlen werden in Integer gecastet und Zeichenketten in Strings. Mit getValue() wird der Wert gelesen, der zum jeweiligem Schlüssel gehört. Es können auch alle Einträge eines Wurzel-Knotens mit getChildren() ausgegeben werden. Das ist nützlich um zum Beispiel alle Produkte zu lesen.

```java

String productID = snapShot.child("productID").getValue().toString();
dataSnapshot.child("products").getChildren())

```


3. [Design](#Design)


Zuerst einmal ist es wichtig aufzuzeigen, dass die Anmeldung zu der Applikation der erster Eindruck bei dem Nutzer machen soll. Somit haben wir uns vorgenommen die Anwendung so zu gestalten, dass der Nutzer zu einer schönen beziehungsweise tollen Anmeldeseite stoßen kann. Dadurch dass wir mit Lebensmitteln arbeiten werden, sollte der Punkt Geschmack und Ästhetik nicht vernachlässigt werden. Um diesen Punkt nachzugehen, haben wir Mithilfe einer Graphikerin ein Logo erstellt. Hinzu kommt, dass die Benutzerfreundlichkeit von höchste Priorität sein soll, damit wir möglichst viele Menschen dazu bewegen können diese Anwendung zu benutzen. Das Anmeldefenster soll dem Nutzer kurze und nötigsten Informationen abfragen, sodass er/sie danach direkt zu den wichtigsten Sachen wie Kaufsuche oder Angebote je nach Orten und Produktbereiche gelangen kann. 

Die Supermärkte sollten sich auch genauso wie die Nutzer anmelden können und wichtige Informationen für die Nutzer bereitstellen können. Es ist hier außerst wichtig zu wissen, dass sie mit wenig Aufwand Produkte, die noch zur Verwendung dienen können, auch in Betracht von Vorschriften der gesetzlichen Rahmenbedingungen anbieten können. Somit können sie Produkte schnell wählen und diese in der Anwendung stellen können. 

Dementsprechend haben wir gesehen mit den Panorama-Bilder in Abschnitt 2.2 und 2.3 wie das aussieht nach dem Testing und wie der Nutzer sowie Supermarkt in verschiedenen Prozessen Schritt für Schritt gelangen wird. 

 
4. [Testing](#Test)


Um dieses Vorgehen einzuleiten kann man der automatisierte Testvorgang wahrnehmen. 
Um die Funktionalität der App während der Entwicklung zu gewährleisten werden Tests durchgeführt. Dies geschieht manuell und auch automatisch. Manuelles Testen erfordert einen hohen Zeitaufwand. Es müssen Ergebnisse und das Verhalten der App überprüft und die Resultate übersichtlich aufgeschrieben werden. Dafür hat der Entwickler die Möglichkeit Einsichten durch Beobachten und Ausprobieren zu erhalten. Fehler fallen dem menschlichen Tester schnell auf. Dafür kann man nicht bei jeder Weiterentwicklung des Codes die komplette App manuell testen. Deswegen verlassen wir uns auf automatisierte Tests. Das Ausführen erfolgt automatisch. Entweder ausgelöst durch das Einbinden in eine Continous-Integration Umgebung wie Jenkins oder auf Wunsch des Entwicklers. Es gibt zwei Arten um Android-Applikation zu testen. Entweder lokal auf der JavaVirtualMachine oder auf einem echten Android-Gerät. Wir haben uns auf lokale Tests mit jUnit konzentriert. Damit werden die elementarsten Komponenten unserer App überprüft.
Danach gelangen wir auf die Unit-Testing.
Mit Unit-Tests werden einzelne Klassen isoliert voneinander getestet. Wir überprüfen ob Klassen nach Initialisierung den gewünschten Zustand haben und ob Methoden richtige Rückgabewerte liefern. Dazu muss in der app/build.gradle die jUnit Abhängigkeit eingetragen werden:

```java


dependencies {
        testImplementation 'junit:junit:4.12'
}

```

Beim Anlegen des Projektes wurde ein Ordner angelegt, der die Unit-Test Klassen enthält. Dieser befindet sich unter ‚app/src/test/java‘ in der Projekt Verzeichnisstruktur. Die zu testenden Klassen müssen in der Unit-Test Klasse importiert werden.

```java

import com.example.retten.retten.model.Addresse;

```

In der Test-Klasse muss zuerst eine Instanz des Objektes erzeugt werden. Dann werden Annahmen über die Resultate von Methodenaufrufen der zu testenden Klasse getroffen. Stimmen diese mit den Rückgabewerten überein ist der Test erfolgreich. Es wird überprüft, ob Objekte Daten korrekt speichern und zurückgeben. 

```java

test_addresse = new Addresse("Straße","Hausnummer",…);
String result = test_addresse.get_streetName();
assertEquals(result, "Straße");

```


Im Android Studio lassen sich mit einem Rechtsklick auf die Test-Klasse mit ‚Run UnitTest‘ die Tests ausführen. In der Console werden die Ergebnisse angezeigt.
Wir können sehen, dass bei uns fast alle Module einzeln genommen funktionniert haben. Das Scannen von QR-Code seitens der Supermärkte nach dem Kaufvorgang hat einige Debugging Probleme uns bereiten, aber am Ende waren diese mit einer akzeptablen Variante gelöst. 


## 4. Zusammenfassung <a name="Fazit"></a>


Im Laufe des Projektes waren Aufgaben des Projekt-Managements zu entdecken. Wir fanden das alle interessant diese Phasen der Software Entwicklung kennengelernt zu haben und den Entwicklungsvorgang in 5 Phasen unterteilt:

```
1.Konzeptphase
2.Definitionsphase
3.Entwurfsphase
4.Fertigungsphase
5.Wartungsphase
```

Während der ersten zwei Phasen war die Suche nach möglichst gute Ideen und eine Vorstellung von dem was einem erwartet von größer Bedeutung. Danach ging in die konkrete Aufgaben um die Entwürfe vorzustellen und diese zu implementieren. Bei der Implementierung sind wir auf viele Probleme, die wir teilweise lösen konnten, gestoßen. Wir haben viel Zeit an die Bearbeitung der Benutzeroberfläche, die als erste Fenster der Interaktion zwischen Nutzer und Anwendung gilt, gewidmet.  
Wenn man auf die Lasten und-Pflichtenheft zurückgreift, merkt man, dass wir es zeitlich nicht geschafft haben die Kann-Option mit einer Karte zur geographischen Orientierung einzubinden. Somit wurde leider der Weg vom Nutzerstandort bis zum Supermarkt nicht berechnenbar sein. Denn wir wollten das so integrieren, dass der Nutzer keinen großen Aufwand verspüren wird, um Produkte, die gleich um die Ecke vorhanden sind, abzuholen. Danach käme die Bewertung der Dienstleistung wo der Kunde die Möglichkeit hätte einige Sternchen für den Service oder den Zustand der Produkte zu geben. Diese Feature wurde leider aus zeitlichen Gründen vernachlässigt. 
Als Entwickler verdienen wir etwas mit der Anwendung indem wir Prozente vor der verkauften Produkten dem Supermarkt zurechnen. Hinzu kommen die Anträge, die wir an dem zuständigen Bundesministerien gestellt hätte, um die Wirtschaftlichkeit unsere Anwendung mitzufinanzieren und auf diesen Punkt einzugehen. 
   
Allerdings ist es hier zu bemerken, dass es uns schwer fiel eine klare Aufgabenverteilung zu erreichen und diese entsprechend zu folgen. Eine reibungsfrei Kommunikation war nicht leicht. Viele von uns besaßen  nicht so große Kenntnisse in Java, deswegen war das Programmieren unter Android Studio eine Herausforderung. 
Wir haben dieses Projekt zusammen geararbeitet und jeder von uns hat Lehren daraus gezogen. In Hinblick auf die Zusammenarbeit sollte man in Zukunft sich mehr sehen und gemeinsam die einzelnen Aufgaben durchgehen, sodass jeder konkret sehen kann was noch fehlt.  
Wir bedanken uns für die Tools, die wir im Rahmen dieses Projekts kennenlernen dürften. Anschließend können wir alle bestätigen, dass wir dieses Projekts sehr interessant war und sehr viel Wissen uns geschenkt hat. 
 






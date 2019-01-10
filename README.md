# retten
<img height="150px" width="250px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Logo_HTW_Berlin.svg/2000px-Logo_HTW_Berlin.svg.png"/>

<div align="center">
        <center>
        
# Retten

### Projekt Softwareentwicklung - WiSe 18/19 

HTW Berlin



##### [Max Ruhnau](https://github.com/MaxArne) 

##### [Giovanni Rodriguez](https://github.com/whiterabbit-ce) 

##### [Alain C.Mendy](https://github.com/amendy) 

##### [Paul Senff](https://github.com/PaulKetchup)

</center>
</div>




#### Inhaltsverzeichnis

1. [Einführung](#introduction)
2. [Produktmodelle](#Modellierung)
   1. [Datenbank](#db)
   2. [Zustandsdiagramm](#ZD)
   3. [Widgets](#Widgets)
   4. [Programme](#Programm)

   
3. [Implementierung](#Implementierung DB)
4. [Implementierung der Anwendung](#db)
   1. [Implementierung der Datenbank in Firebase](#dbFirebase)
   2. [Datenbank in Android Studio](#dbAndroidStudio)
   3. [Design](#Design)
   4. [Testing](#Test)
       
5. [Zusammenfassung](#Fazit)



## Einführung <a name="introduction"></a>

## Abstrakt

## Produktidee

## Ziele 

## Produktmodelle <a name="Produktmodelle"></a>

.....

## Datenbank


![Datenbank](<a href="https://imgur.com/eSOT5mS"><img src="https://i.imgur.com/eSOT5mS.jpg" title="source: imgur.com" /></a>)

2. Zustandsdiagramm

![Zustandsdiagramm](<a href="https://imgur.com/dbI6BT8"><img src="https://i.imgur.com/dbI6BT8.jpg" title="source: imgur.com" /></a>)

3. Widgets

![Widgets](https://i.imgur.com/...)






## Implementierung der Anwendung <a name="#db"></a>

Bei der Wahl der Technologie haben wir uns für die Tool-Suite „Firebase“ von Google entschieden. Diese beinhaltet umfangreiche Funktionalitäten. Für die Datenbank wird die „Realtime Database“ genutzt. Damit ist es möglich sehr effizient zu entwickeln und es wird dem Programmierer viel Konfiguration abgenommen. Außerdem ist sichergestellt, dass diese Technologie fehlerfrei funktioniert und auch unter hohen Belastungen standhält. Es muss kein Server initialisiert werden. Daten werden in der Cloud gespeichert. Es handelt sich um eine nicht relationale Datenbank (NoSQL). Einer der Hauptgründe für die Wahl dieser Technologie sind die Synchronisationsmechanismen in Echtzeit. Sogenannte Event-Listener überprüfen dauerhaft ob sich Daten geändert haben. Jedes Gerät welches mit dieser Datenbank verbunden ist aktualisiert sich automatisch. Somit werden keine komplizierten Netzwerkbibliotheken benötigt. Ein weiterer Vorteil ist das garantierte Funktionieren der App bei Verbindungsunterbrechungen des Gerätes mit dem Internet. Der aktuelle Zustand der Datenbank wird lokal auf dem Gerät gespeichert. Auf diesen Datenbestand wird zugegriffen, wenn die Datenbank in der Cloud nicht erreichbar ist. Sobald die Internetverbindung wieder aufgebaut wird erhält der Klient den aktuellen Datenbestand.
Im Gegensatz zu SQL-Datenbanken werden keine Tabellen und Relationen verwendet. Alle Daten sind JSON-Objekte. Beim Hinzufügen eines Objektes wird ein neuer Knoten in diesem Baum erzeugt. Jeder Knoten ist eindeutig durch einen Schlüssel identifizierbar. Das Datenbankmodell mit seinen Entitäten wird in Java-Klassen umgesetzt. Jede Entität entspricht eine Klasse mit Attributen. Attribute ergeben Kind-Knoten mit einem Schlüssel – Werte Paar. So ergibt sich eine Verschachtelung mit mehreren Ebenen. Beim Entwurf wurde darauf geachtet, dass die Verschachtelung eine geringe Anzahl von Ebenen, eine geringe Tiefe aufweist. Die Methoden sind nicht von Relevanz. Dazu wird im Projektverzeichnis ein neuer Ordner ‚database‘ angelegt. Dort entspricht jede Datei einer Java Klasse. Es wurden die Klassen  ‚Supermarkt‘ und ‚Produkt‘ angelegt. Die Attribute der Klassen wie z.B. ‚Marktname‘ oder ‚Öffnungszeit‘ entsprechen Einträge in den JSON-Objekten. Beim Erzeugen eines Objektes wird ein Knoten in der JSON-Baumstruktur angelegt.

## Implementierung der Datenbank in Firebase <a name="dbFirebase"></a>

Im Android-Studio ist Firebase bereits installiert. Es muss dem Projekt als Abhängigkeit hinzugefügt werden. Dazu wird in der build.gradle Datei ein entsprechender Eintrag im ‚dependency‘ Codeabschnitt eingefügt.
implementation 'com.google.firebase:firebase-database:16.0.5'

Dabei ist die Versionsnummer zu beachten. Diese muss mit den anderen übereinstimmen, sonst ist das Projekt nicht kompilierbar. Beim Start der App wird die Datenbank initialisiert. Dazu wird eine Instanz erzeugt und dann die Referenz in einer Variablen gespeichert.
private DatabaseReference mDatabase;

mDatabase = FirebaseDatabase.getInstance().getReference();

Diese Referenz wird verwendet, wenn Daten in die Datenbank geschrieben werden. Um Daten auf Veränderung zu überprüfen und daraufhin den Zustand der App entsprechend zu aktualisieren werden asynchrone Listener an die Referenz übergeben. Das ist zum Beispiel die periodische Dekrementierung des Ablaufdatums.  Der Listener wird am Anfang und bei Veränderung der zu überwachenden Daten aufgerufen. Wegen der Veränderung des Ablaufdatums ändert sich die Anzeige auf der Oberfläche, dem TextView. Der Benutzer weiß sofort Bescheid. Für das Hinzufügen von ‚Supermarkt‘ und ‚Produkt‘ wird jeweils eine eigene Activity angelegt. In diesen Activities befinden sich lokale Referenzen auf die Firebase Datenbank. Außerdem wird eine Liste mit ‚Supermarkt‘ bzw. ‚Produkt‘ Objekten angelegt. Beim Hinzufügen von Produkt Objekten werden diese in eine in eine ‚ShoppingItem‘ Wrapper Klasse gespeichert. EditText Boxen erhalten Input vom Benutzer und beim Klick auf ‚Hinzufügen‘ wird ein neues Objekt an diese Liste angehängt. 
ArrayList<ShoppingItem> productList = new ArrayList<>();

productList.add(new ShoppingItem(productid.getText().toString()…));

Dann wird die Liste von ‚Produkt‘ Objekten in eine HashMap eingelesen um damit in der Datenbank eine Struktur zu erzeugen. Die Datenbank wird mit updateChildren() aktualisiert. Mit dieser Funktion wird auch sichergestellt, dass keine bereits existierenden Einträge überschrieben werden. Es wird ein Wurzel(root)-Knoten mit der Bezeichnung ‚products‘ erstellt. Die ‚productList‘ wird in einzelne Einträge unter diesem Wurzel-Knoten übersetzt. ‚Produkt‘ JSON Objekte sind Schlüßel-Werte Paaren, die die Attribute mit aktuellen Werten enthalten.
Map<String, Object> cartItemsMap = new HashMap<>();
cartItemsMap.put("products", productList);
mDatabase.updateChildren(cartItemsMap);

Um das Lesen zu implementieren wird ein ‚ValueEventListener‘ für die Datenbank Referenz erzeugt. Wenn sich ein Wert ändert wird eine Callback-Methode OnDataChange() aufgerufen. Es wird ein Snapshot erstellt, der den Zustand der Datenbank zum Zeitpunkt der Wertänderung enthält.

mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        IndividualProduct.this.dataSnapshot = dataSnapshot;
    }
});
Aus diesem Snapshot können Werte gelesen werden. Dazu wird der entsprechende Schlüßel angegeben. Hauptsächlich werden Produkte gelesen, die von Supermärkten hinzugefügt wurden. Diese Produkte werden den Benutzern in der App angezeigt. Es ist oft notwendig gelesene Werte in geeignete Variablen-Typen umzuwandeln. Zahlen werden in Integer gecastet und Zeichenketten in Strings. Mit getValue() wird der Wert gelesen, der zum jeweiligem Schlüssel gehört. Es können auch alle Einträge eines Wurzel-Knotens mit getChildren() ausgegeben werden. Das ist nützlich um zum Beispiel alle Produkte zu lesen.
String productID = snapShot.child("productID").getValue().toString();
dataSnapshot.child("products").getChildren())





## Implementierung in Android Studio <a name="dbAndroidStudio"></a>

Automatisiertes Testen
Um die Funktionalität der App während der Entwicklung zu gewährleisten werden Tests durchgeführt. Dies geschieht manuell und auch automatisch. Manuelles Testen erfordert einen hohen Zeitaufwand. Es müssen Ergebnisse und das Verhalten der App überprüft und die Resultate übersichtlich aufgeschrieben werden. Dafür hat der Entwickler die Möglichkeit Einsichten durch Beobachten und Ausprobieren zu erhalten. Fehler fallen dem menschlichen Tester schnell auf. Dafür kann man nicht bei jeder Weiterentwicklung des Codes die komplette App manuell testen. Deswegen verlassen wir uns auf automatisierte Tests. Das Ausführen erfolgt automatisch. Entweder ausgelöst durch das Einbinden in eine Continous-Integration Umgebung wie Jenkins oder auf Wunsch des Entwicklers. Es gibt zwei Arten um Android-Applikation zu testen. Entweder lokal auf der JavaVirtualMachine oder auf einem echten Android-Gerät. Wir haben uns auf lokale Tests mit jUnit konzentriert. Damit werden die elementarsten Komponenten unserer App überprüft.
Unit Testing
Mit Unit-Tests werden einzelne Klassen isoliert voneinander getestet. Wir überprüfen ob Klassen nach Initialisierung den gewünschten Zustand haben und ob Methoden richtige Rückgabewerte liefern. Dazu muss in der app/build.gradle die jUnit Abhängigkeit eingetragen werden:
dependencies {
        testImplementation 'junit:junit:4.12'
}

Beim Anlegen des Projektes wurde ein Ordner angelegt, der die Unit-Test Klassen enthält. Dieser befindet sich unter ‚app/src/test/java‘ in der Projekt Verzeichnisstruktur. Die zu testenden Klassen müssen in der Unit-Test Klasse importiert werden.

import com.example.retten.retten.model.Addresse;

In der Test-Klasse muss zuerst eine Instanz des Objektes erzeugt werden. Dann werden Annahmen über die Resultate von Methodenaufrufen der zu testenden Klasse getroffen. Stimmen diese mit den Rückgabewerten überein ist der Test erfolgreich. Es wird überprüft ob Objekte Daten korrekt speichern und zurückgeben. 

test_addresse = new Addresse("Straße","Hausnummer",…);
String result = test_addresse.get_streetName();
assertEquals(result, "Straße");

Im Android Studio lassen sich mit einem Rechtsklick auf die Test-Klasse mit ‚Run UnitTest‘ die Tests ausführen. In der Console werden die Ergebnisse angezeigt.


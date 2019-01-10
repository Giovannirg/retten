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

## Implementierung der Datenbank in Firebase <a name="dbFirebase"></a>







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


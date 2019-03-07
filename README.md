# HOEK-helper

Datamatiker 3-ugersprojekt i samarbejde med handelsøkonomer.

## Links

* Link til WhiteBoard - https://goo.gl/QzqSNJ
* Guide til Artefakter - https://goo.gl/MKAJeF
* Links til eksempler, tjeklister og noter - https://goo.gl/Ge5JPR
* Link til dias for Opsætning af udviklingsmiljø og brugervejlednings gruppen - https://goo.gl/zYCaoz
* Project Manager - https://goo.gl/s6Mnmt
* Google Drive mappe - https://goo.gl/UQ6d1h

## Standarder for Android-projektet

* compileSdkVersion: 28 <br>
* minSdkVersion 15 <br>
* targetSdkVersion 28 <br>

## Regler for arbejde i projektet

1. Start en **ny branch** hver gang du starter på en ny opgave, giv branchen et sigende navn, fx den opgave du arbejder på.
2. Pull before Push.
3. Du skal sikre dig, at ingen er i gang med at merge en branch til master branch før du selv begynder en merge.
4. Ved commit, lav en **sigende commit text**, beskriv hvad du har lavet/ har ændret, muligvis med begrundelse.
5. Alle Views, som TextView og EditText skal have et ID hvor typen indgår til sidst fx: "interest_rate_et" hvor "et" står for EditText.
6. Når Views tilgås som member-variables, bruges konventionen: "m(Navn)(Type)" som fx "mInterestRateEditText".

## Forklaringer på regler

1. Hvis alle arbejder i samme branch, fører det til konflikter, som ikke kan forenes.
2. Hvis der er ændringer i master som du ikke har implementeret vil der komme konflikter som kan være umulige at udrede.
3. Ved simultane merges skal der bruges tid til at forlige de forskellige merges.
4. Ved en commit text som "hest" skal koden gennemgås før ændringerne eller tilføjelserne kan forståes.
5. Ved at give tilfældige ID'er til Views gør du det svært for andre og dig selv at bruge/finde de Views du har lavet.
6. se 5.

## Navnekonvension for filer og artefakter

1. Alle artefakter skal have et unikt ID, som består af forkortelse af artefakt navn og nummer, fx UC-01, som er den første Use Case.
2. Hvis artefakter hænger sammen, fx en Domæne Model over en Use Case, skal begge dele nummer i deres ID, fx UC-01 og DM-01.
3. Giv andre filer beskrivende navne i CamelCase.

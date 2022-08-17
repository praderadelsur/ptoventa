echo off
echo Realizando respaldo en archivo %1...
                                  
echo Ejecutando el respaldo ...
C:\wamp\bin\mysql\mysql5.5.20\bin\mysqldump.exe -u root test>%1

echo Despliego archivo
dir %1

Echo Proceso finalizado

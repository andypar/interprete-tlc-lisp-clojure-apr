# **Intérprete de TLC-LISP en Clojure**

## Actualmente,  TLC-LISP ya no  se  comercializa  más  y,   en  consecuencia,  para  utilizar  el  software  existente desarrollado en él, se desea construir en este trabajo práctico un intérprete que corra en la JVM (Java Virtual Machine). Por ello, el lenguaje elegido para su implementación es Clojure. Deberá  poder  cargarse  y  correrse  el  siguiente  Sistema  de  Producción,  que  resuelve  el  problema  de  obtener 4 litros de líquido utilizando dos jarras lisas (sin escala), una de 5 litros y otra de 8 litros. (Ver 07 - TP 2022.pdf)

### 1) TUTORIAL:

`lein run`
`(load 'demo)`
`(exit)`

### 2) TESTS:

`lein test`

### 3) JARRAS:

`lein run`
`(load 'jarras)`
`(breadth-first bc)`
`(0 0)`
`(0 4)`
`(exit)`

### 4) EJECUTABLE COMPILADO:

`java -jar app-0.1.0-SNAPSHOT-standalone.jar`


 
(ns app.core-test
	(:require [clojure.test :refer :all]
						[app.core :refer :all]))


; controlar-aridad
(deftest controlar-aridad-test1
	(testing "Prueba 1 de la funcion: controlar-aridad"
		(is (= 3 (controlar-aridad '(a b c) 3)))))

(deftest controlar-aridad-test2
	(testing "Prueba 2 de la funcion: controlar-aridad"
		(is (= '(*error* too-many-args) (controlar-aridad '(a b c) 2)))))

(deftest controlar-aridad-test3
	(testing "Prueba 3 de la funcion: controlar-aridad"
		(is (= '(*error* too-few-args) (controlar-aridad '(a b c) 4)))))


; igual
(deftest igual-test1
	(testing "Prueba 1 de la funcion: igual" (is (= true (igual? 1 1)))))

(deftest igual-test2
	(testing "Prueba 2 de la funcion: igual" (is (= true (igual? 'a 'a)))))

(deftest igual-test3
	(testing "Prueba 3 de la funcion: igual" (is (= true (igual? 'A 'A)))))

(deftest igual-test4
	(testing "Prueba 4 de la funcion: igual" (is (= true (igual? 'a 'A)))))

(deftest igual-test5
	(testing "Prueba 5 de la funcion: igual" (is (= true (igual? 'A 'a)))))

(deftest igual-test6
	(testing "Prueba 6 de la funcion: igual"
		(is (= true (igual? '(a b c) '(A B C))))))

(deftest igual-test7
	(testing "Prueba 7 de la funcion: igual" (is (= true (igual? nil nil)))))

(deftest igual-test8
	(testing "Prueba 8 de la funcion: igual" (is (= true (igual? nil 'NIL)))))

(deftest igual-test9
	(testing "Prueba 9 de la funcion: igual" (is (= true (igual? 'NIL nil)))))

(deftest igual-test10
	(testing "Prueba 10 de la funcion: igual" (is (= true (igual? 'NIL 'NIL)))))

(deftest igual-test11
	(testing "Prueba 11 de la funcion: igual" (is (= true (igual? nil ())))))

(deftest igual-test12
	(testing "Prueba 12 de la funcion: igual" (is (= true (igual? 'NIL ())))))

(deftest igual-test13
	(testing "Prueba 13 de la funcion: igual" (is (= true (igual? () ())))))

(deftest igual-test14
	(testing "Prueba 14 de la funcion: igual" (is (= true (igual? "a" "a")))))

(deftest igual-test15
	(testing "Prueba 15 de la funcion: igual" (is (= false (igual? 1 2)))))

(deftest igual-test16
	(testing "Prueba 16 de la funcion: igual" (is (= false (igual? 'a 'b)))))

(deftest igual-test17
	(testing "Prueba 17 de la funcion: igual"
		(is (= false (igual? '(a b c) '(A B D))))))

(deftest igual-test18
	(testing "Prueba 18 de la funcion: igual" (is (= false (igual? () '(nil))))))

(deftest igual-test19
	(testing "Prueba 19 de la funcion: igual" (is (= false (igual? "a" "A")))))

(deftest igual-test20
	(testing "Prueba 20 de la funcion: igual" (is (= false (igual? 'a "a")))))

(deftest igual-test21
	(testing "Prueba 21 de la funcion: igual" (is (= false (igual? 'a "A")))))


; error
(deftest error-test1
	(testing "Prueba 1 de la funcion: error"
		(is (= true (error? '(*error* too-few-args))))))

(deftest error-test2
	(testing "Prueba 2 de la funcion: error"
		(is (= true (error? (list '*error* 'too-few-args))))))

(deftest error-test3
	(testing "Prueba 3 de la funcion: error"
		(is (= true (error? (list '*ERROR* 'too-few-args))))))

(deftest error-test4
	(testing "Prueba 4 de la funcion: error"
		(is (= true (error? (list '*Error* 'too-few-args))))))

(deftest error-test5
	(testing "Prueba 5 de la funcion: error"
		(is (= true (error? (list '*error*))))))

(deftest error-test6
	(testing "Prueba 6 de la funcion: error"
		(is (= false (error? (list 'too-few-args))))))

(deftest error-test7
	(testing "Prueba 7 de la funcion: error" (is (= false (error? '*error*)))))

(deftest error-test8
	(testing "Prueba 8 de la funcion: error" (is (= false (error? ())))))

(deftest error-test9
	(testing "Prueba 9 de la funcion: error" (is (= false (error? nil)))))


; revisar-fnc
(deftest revisar-fnc-test1
	(testing "Prueba 1 de la funcion: revisar-fnc"
		(is (= '(*error* too-few-args)
					(revisar-fnc '(*error* too-few-args))))))

(deftest revisar-fnc-test2
	(testing "Prueba 2 de la funcion: revisar-fnc"
		(is (= nil (revisar-fnc '(too-few-args))))))

(deftest revisar-fnc-test3
	(testing "Prueba 3 de la funcion: revisar-fnc"
		(is (= nil (revisar-fnc '*error*)))))

(deftest revisar-fnc-test4
	(testing "Prueba 4 de la funcion: revisar-fnc"
		(is (= nil (revisar-fnc nil)))))

(deftest revisar-fnc-test5
	(testing "Prueba 5 de la funcion: revisar-fnc" (is (= nil (revisar-fnc ())))))


; revisar-lae
(deftest revisar-lae-test1
	(testing "Prueba 1 de la funcion: revisar-lae"
		(is (= nil (revisar-lae '(1 2 3))))))

(deftest revisar-lae-test2
	(testing "Prueba 2 de la funcion: revisar-lae"
		(is (= nil (revisar-lae nil)))))

(deftest revisar-lae-test3
	(testing "Prueba 3 de la funcion: revisar-lae" (is (= nil (revisar-lae ())))))

(deftest revisar-lae-test4
	(testing "Prueba 4 de la funcion: revisar-lae"
		(is (= '(*error* too-few-args)
					(revisar-lae '(1 (*error* too-few-args) 3))))))

(deftest revisar-lae-test5
	(testing "Prueba 5 de la funcion: revisar-lae"
		(is (= '(*error* too-few-args)
					(revisar-lae
						'(1 (*error* too-few-args) (*error* too-many-args) 3))))))


; actualizar-amb
(deftest actualizar-ambiente-test1
	(testing "Prueba 1 de la funcion: actualizar-ambiente"
		(is (= '(a 1 b 2 c 3 d 4) (actualizar-amb '(a 1 b 2 c 3) 'd 4)))))

(deftest actualizar-ambiente-test2
	(testing "Prueba 2 de la funcion: actualizar-ambiente"
		(is (= '(a 1 b 4 c 3) (actualizar-amb '(a 1 b 2 c 3) 'b 4)))))

(deftest actualizar-ambiente-test3
	(testing
		"Prueba 3 de la funcion: actualizar-ambiente"
		(is (= '(a 1 b 2 c 3)
					(actualizar-amb '(a 1 b 2 c 3) 'b (list '*error* 'mal 'hecho))))))

(deftest actualizar-ambiente-test4
	(testing "Prueba 4 de la funcion: revisar-ambiente"
		(is (= '(b 7) (actualizar-amb () 'b 7)))))


; buscar
(deftest buscar-test1
	(testing "Prueba 1 de la funcion: buscar"
		(is (= 3 (buscar 'c '(a 1 b 2 c 3 d 4 e 5))))))

(deftest buscar-test2
	(testing "Prueba 2 de la funcion: buscar"
		(is (= '(*error* unbound-symbol f)
					(buscar 'f '(a 1 b 2 c 3 d 4 e 5))))))


; fnc-append
(deftest fnc-append-test1
	(testing "Prueba 1 de la funcion: fnc-append"
		(is (= '(*error* too-few-args) (fnc-append '((1 2)))))))

(deftest fnc-append-test2
	(testing "Prueba 2 de la funcion: fnc-append"
		(is (= '(*error* too-many-args)
					(fnc-append '((1 2) (3) (4 5) (6 7)))))))

(deftest fnc-append-test3
	(testing "Prueba 3 de la funcion: fnc-append"
		(is (= '(*error* list expected 3) (fnc-append '((1 2) 3))))))

(deftest fnc-append-test4
	(testing "Prueba 4 de la funcion: fnc-append"
		(is (= '(*error* list expected A) (fnc-append '((1 2) A))))))

(deftest fnc-append-test5
	(testing "Prueba 5 de la funcion: fnc-append"
		(is (= '(1 2 3) (fnc-append '((1 2) (3)))))))

(deftest fnc-append-test6
	(testing "Prueba 6 de la funcion: fnc-append"
		(is (= '(1 2) (fnc-append '((1 2) nil))))))

(deftest fnc-append-test7
	(testing "Prueba 7 de la funcion: fnc-append"
		(is (= '(1 2) (fnc-append '(() (1 2)))))))

(deftest fnc-append-test8
	(testing "Prueba 8 de la funcion: fnc-append"
		(is (= nil (fnc-append '(nil nil))))))

(deftest fnc-append-test9
	(testing "Prueba 9 de la funcion: fnc-append"
		(is (= nil (fnc-append '(() ()))))))


; fnc-env
(deftest fnc-env-test1
	(testing "Prueba 1 de la funcion: fnc-env"
		(is (= '(a 1 b 2 c 3 d 4) (fnc-env () '(a 1 b 2) '(c 3 d 4))))))

(deftest fnc-env-test2
	(testing "Prueba 2 de la funcion: fnc-env"
		(is (= '(*error* too-many-args)
					(fnc-env '(5) '(a 1 b 2) '(c 3 d 4))))))


; fnc-equal
(deftest fnc-equal-test1
	(testing "Prueba 1 de la funcion: fnc-equal" (is (= 't (fnc-equal '(1 1))))))

(deftest fnc-equal-test2
	(testing "Prueba 2 de la funcion: fnc-equal" (is (= 't (fnc-equal '(A a))))))

(deftest fnc-equal-test3
	(testing "Prueba 3 de la funcion: fnc-equal"
		(is (= 't (fnc-equal '("1" "1"))))))

(deftest fnc-equal-test4
	(testing "Prueba 4 de la funcion: fnc-equal"
		(is (= 't (fnc-equal '(nil NIL))))))

(deftest fnc-equal-test5
	(testing "Prueba 5 de la funcion: fnc-equal" (is (= nil (fnc-equal '(1 2))))))

(deftest fnc-equal-test6
	(testing "Prueba 6 de la funcion: fnc-equal" (is (= nil (fnc-equal '(A B))))))

(deftest fnc-equal-test7
	(testing "Prueba 7 de la funcion: fnc-equal"
		(is (= nil (fnc-equal '("1" 1))))))

(deftest fnc-equal-test8
	(testing "Prueba 8 de la funcion: fnc-equal"
		(is (= '(*error* too-few-args) (fnc-equal ())))))

(deftest fnc-equal-test9
	(testing "Prueba 9 de la funcion: fnc-equal"
		(is (= '(*error* too-few-args) (fnc-equal '(A))))))

(deftest fnc-equal-test10
	(testing "Prueba 10 de la funcion: fnc-equal"
		(is (= '(*error* too-many-args) (fnc-equal '(A a A))))))


; fnc-read
(deftest fnc-read-test1
	(testing "Prueba 1 de la funcion: fnc-read"
		(with-redefs [read (fn[] 1)  ]
			(is (= 1 (fnc-read ()))))))

(deftest fnc-read-test2
	(testing "Prueba 2 de la funcion: fnc-read"
		(with-redefs [read (fn[] 'a)  ]
			(is (= 'a (fnc-read ()))))))

(deftest fnc-read-test3
	(testing "Prueba 3 de la funcion: fnc-read"
		(with-redefs [read (fn[] "hola")  ]
			(is (= "hola" (fnc-read ()))))))

(deftest fnc-read-test4
	(testing "Prueba 4 de la funcion: fnc-read"
		(with-redefs [read (fn[] '(hola mundo))  ]
			(is (= '(hola mundo) (fnc-read ()))))))

(deftest fnc-read-test5
	(testing "Prueba 5 de la funcion: fnc-read"
		(with-redefs [read (fn[] '(hola
																mundo))  ]
			(is (= '(hola
								mundo) (fnc-read ()))))))

(deftest fnc-read-test6
	(testing "Prueba 6 de la funcion: fnc-read"
		(with-redefs [read (fn[] ())  ]
			(is (= nil (fnc-read ()))))))

(deftest fnc-read-test7
	(testing "Prueba 7 de la funcion: fnc-read"
		(with-redefs [read (fn[] nil)  ]
			(is (= nil (fnc-read ()))))))

(deftest fnc-read-test8
	(testing "Prueba 8 de la funcion: fnc-read"
		(is (= '(*error* not-implemented) (fnc-read '(1))))))

(deftest fnc-read-test9
	(testing "Prueba 9 de la funcion: fnc-read"
		(is (= '(*error* not-implemented) (fnc-read '(1 2))))))


; fnc-terpri
(deftest fnc-terpri-test1
	(testing "Prueba 1 de la funcion: fnc-terpri"
		(is (= (newline) (fnc-terpri ())))))

(deftest fnc-terpri-test2
	(testing "Prueba 2 de la funcion: fnc-terpri"
		(is (= '(*error* not-implemented) (fnc-terpri '(1))))))

(deftest fnc-terpri-test3
	(testing "Prueba 3 de la funcion: fnc-terpri"
		(is (= '(*error* not-implemented) (fnc-terpri '(1 2))))))


; fnc-add
(deftest fnc-add-test1
	(testing "Prueba 1 de la funcion: fnc-add" (is (= 7 (fnc-add '(3 4))))))

(deftest fnc-add-test2
	(testing "Prueba 2 de la funcion: fnc-add" (is (= 12 (fnc-add '(3 4 5))))))

(deftest fnc-add-test3
	(testing "Prueba 3 de la funcion: fnc-add" (is (= 18 (fnc-add '(3 4 5 6))))))

(deftest fnc-add-test4
	(testing "Prueba 4 de la funcion: fnc-add"
		(is (= '(*error* too-few-args) (fnc-add ())))))

(deftest fnc-add-test5
	(testing "Prueba 5 de la funcion: fnc-add"
		(is (= '(*error* too-few-args) (fnc-add '(3))))))

(deftest fnc-add-test6
	(testing "Prueba 6 de la funcion: fnc-add"
		(is (= '(*error* number-expected A) (fnc-add '(A 4 5 6))))))

(deftest fnc-add-test7
	(testing "Prueba 7 de la funcion: fnc-add"
		(is (= '(*error* number-expected A) (fnc-add '(3 A 5 6))))))

(deftest fnc-add-test8
	(testing "Prueba 8 de la funcion: fnc-add"
		(is (= '(*error* number-expected A) (fnc-add '(3 4 A 6))))))


; fnc-sub
(deftest fnc-sub-test1
	(testing "Prueba 1 de la funcion: fnc-sub"
		(is (= '(*error* too-few-args) (fnc-sub ())))))

(deftest fnc-sub-test2
	(testing "Prueba 2 de la funcion: fnc-sub" (is (= -3 (fnc-sub '(3))))))

(deftest fnc-sub-test3
	(testing "Prueba 3 de la funcion: fnc-sub" (is (= -1 (fnc-sub '(3 4))))))

(deftest fnc-sub-test4
	(testing "Prueba 4 de la funcion: fnc-sub" (is (= -6 (fnc-sub '(3 4 5))))))

(deftest fnc-sub-test5
	(testing "Prueba 5 de la funcion: fnc-sub" (is (= -12 (fnc-sub '(3 4 5 6))))))

(deftest fnc-sub-test6
	(testing "Prueba 6 de la funcion: fnc-sub"
		(is (= '(*error* number-expected A) (fnc-sub '(A 4 5 6))))))

(deftest fnc-sub-test7
	(testing "Prueba 7 de la funcion: fnc-sub"
		(is (= '(*error* number-expected A) (fnc-sub '(3 A 5 6))))))

(deftest fnc-sub-test8
	(testing "Prueba 8 de la funcion: fnc-sub"
		(is (= '(*error* number-expected A) (fnc-sub '(3 4 A 6))))))


; fnc-lt
(deftest fnc-lt-test1
	(testing "Prueba 1 de la funcion: fnc-lt"
		(is (= '(*error* too-few-args) (fnc-lt ())))))

(deftest fnc-lt-test2
	(testing "Prueba 2 de la funcion: fnc-lt"
		(is (= '(*error* too-few-args) (fnc-lt '(1))))))

(deftest fnc-lt-test3
	(testing "Prueba 3 de la funcion: fnc-lt" (is (= 't (fnc-lt '(1 2))))))

(deftest fnc-lt-test4
	(testing "Prueba 4 de la funcion: fnc-lt" (is (= nil (fnc-lt '(1 1))))))

(deftest fnc-lt-test5
	(testing "Prueba 5 de la funcion: fnc-lt" (is (= nil (fnc-lt '(2 1))))))

(deftest fnc-lt-test6
	(testing "Prueba 6 de la funcion: fnc-lt"
		(is (= '(*error* number-expected A) (fnc-lt '(A 1))))))

(deftest fnc-lt-test7
	(testing "Prueba 7 de la funcion: fnc-lt"
		(is (= '(*error* number-expected A) (fnc-lt '(1 A))))))

(deftest fnc-lt-test8
	(testing "Prueba 8 de la funcion: fnc-lt"
		(is (= '(*error* too-many-args) (fnc-lt '(1 2 3))))))


; fnc-gt
(deftest fnc-gt-test1
	(testing "Prueba 1 de la funcion: fnc-gt"
		(is (= '(*error* too-few-args) (fnc-gt ())))))

(deftest fnc-gt-test2
	(testing "Prueba 2 de la funcion: fnc-gt"
		(is (= '(*error* too-few-args) (fnc-gt '(1))))))

(deftest fnc-gt-test3
	(testing "Prueba 3 de la funcion: fnc-gt" (is (= nil (fnc-gt '(1 2))))))

(deftest fnc-gt-test4
	(testing "Prueba 4 de la funcion: fnc-gt" (is (= nil (fnc-gt '(1 1))))))

(deftest fnc-gt-test5
	(testing "Prueba 5 de la funcion: fnc-gt" (is (= 't (fnc-gt '(2 1))))))

(deftest fnc-gt-test6
	(testing "Prueba 6 de la funcion: fnc-gt"
		(is (= '(*error* number-expected A) (fnc-gt '(A 1))))))

(deftest fnc-gt-test7
	(testing "Prueba 7 de la funcion: fnc-gt"
		(is (= '(*error* number-expected A) (fnc-gt '(1 A))))))

(deftest fnc-gt-test8
	(testing "Prueba 8 de la funcion: fnc-gt"
		(is (= '(*error* too-many-args) (fnc-gt '(1 2 3))))))


; fnc-ge
(deftest fnc-ge-test1
	(testing "Prueba 1 de la funcion: fnc-ge"
		(is (= '(*error* too-few-args) (fnc-ge ())))))

(deftest fnc-ge-test2
	(testing "Prueba 2 de la funcion: fnc-ge"
		(is (= '(*error* too-few-args) (fnc-ge '(1))))))

(deftest fnc-ge-test3
	(testing "Prueba 3 de la funcion: fnc-ge" (is (= nil (fnc-ge '(1 2))))))

(deftest fnc-ge-test4
	(testing "Prueba 4 de la funcion: fnc-ge" (is (= 't (fnc-ge '(1 1))))))

(deftest fnc-ge-test5
	(testing "Prueba 5 de la funcion: fnc-ge" (is (= 't (fnc-ge '(2 1))))))

(deftest fnc-ge-test6
	(testing "Prueba 6 de la funcion: fnc-ge"
		(is (= '(*error* number-expected A) (fnc-ge '(A 1))))))

(deftest fnc-ge-test7
	(testing "Prueba 7 de la funcion: fnc-ge"
		(is (= '(*error* number-expected A) (fnc-ge '(1 A))))))

(deftest fnc-ge-test8
	(testing "Prueba 8 de la funcion: fnc-ge"
		(is (= '(*error* too-many-args) (fnc-ge '(1 2 3))))))


; fnc-reverse
(deftest fnc-reverse-test1
	(testing "Prueba 1 de la funcion: fnc-reverse"
		(is (= '(*error* too-few-args) (fnc-reverse ())))))

(deftest fnc-reverse-test2
	(testing "Prueba 2 de la funcion: fnc-reverse"
		(is (= '(*error* list expected 1) (fnc-reverse '(1))))))

(deftest fnc-reverse-test3
	(testing "Prueba 3 de la funcion: fnc-reverse"
		(is (= '(*error* list expected A) (fnc-reverse '(A))))))

(deftest fnc-reverse-test4
	(testing "Prueba 4 de la funcion: fnc-reverse"
		(is (= '(1) (fnc-reverse '((1)))))))

(deftest fnc-reverse-test5
	(testing "Prueba 5 de la funcion: fnc-reverse"
		(is (= '(3 2 1) (fnc-reverse '((1 2 3)))))))

(deftest fnc-reverse-test6
	(testing "Prueba 6 de la funcion: fnc-reverse"
		(is (= '(*error* too-many-args) (fnc-reverse '((1 2 3) (4)))))))


; evaluar-escalar
(deftest evaluar-escalar-test1
	(testing "Prueba 1 de la funcion: evaluar-escalar"
		(is (= '(32 (v 1 w 3 x 6))
					(evaluar-escalar 32 '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test2
	(testing "Prueba 2 de la funcion: evaluar-escalar"
		(is
			(= '("chau" (v 1 w 3 x 6))
				(evaluar-escalar "chau" '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test3
	(testing "Prueba 3 de la funcion: evaluar-escalar"
		(is (= '("hola" (v 1 w 3 x 6))
					(evaluar-escalar 'z '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test4
	(testing "Prueba 4 de la funcion: evaluar-escalar"
		(is (= '("hola" (v 1 w 3 x 6))
					(evaluar-escalar 'Z '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test5
	(testing "Prueba 5 de la funcion: evaluar-escalar"
		(is (= '(3 (v 1 w 3 x 6))
					(evaluar-escalar 'w '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test6
	(testing "Prueba 6 de la funcion: evaluar-escalar"
		(is (= '(5 (v 1 w 3 x 6))
					(evaluar-escalar 'x '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))

(deftest evaluar-escalar-test7
	(testing "Prueba 7 de la funcion: evaluar-escalar"
		(is (= '((*error* unbound-symbol n) (v 1 w 3 x 6))
					(evaluar-escalar 'n '(v 1 w 3 x 6) '(x 5 y 11 z "hola"))))))


; evaluar-de
(deftest evaluar-de-test1
	(testing "Prueba 1 de la funcion: evaluar-de"
		(is (= '(f (x 1 f (lambda (x)))) (evaluar-de '(de f (x)) '(x 1))))))

(deftest evaluar-de-test2
	(testing "Prueba 2 de la funcion: evaluar-de"
		(is (= '(f (x 1 f (lambda (x) 2)))
					(evaluar-de '(de f (x) 2) '(x 1))))))

(deftest evaluar-de-test3
	(testing "Prueba 3 de la funcion: evaluar-de"
		(is (= '(f (x 1 f (lambda (x) (+ x 1))))
					(evaluar-de '(de f (x) (+ x 1)) '(x 1))))))

(deftest evaluar-de-test4
	(testing "Prueba 4 de la funcion: evaluar-de"
		(is (= '(f (x 1 f (lambda (x y) (+ x y))))
					(evaluar-de '(de f (x y) (+ x y)) '(x 1))))))

(deftest evaluar-de-test5
	(testing "Prueba 5 de la funcion: evaluar-de"
		(is (= '(f (x 1 f (lambda (x y) (prin3 x) (terpri) y)))
					(evaluar-de '(de f (x y) (prin3 x) (terpri) y) '(x 1))))))

(deftest evaluar-de-test6
	(testing "Prueba 6 de la funcion: evaluar-de"
		(is (= '((*error* list expected nil) (x 1))
					(evaluar-de '(de) '(x 1))))))

(deftest evaluar-de-test7
	(testing "Prueba 7 de la funcion: evaluar-de"
		(is (= '((*error* list expected nil) (x 1))
					(evaluar-de '(de f) '(x 1))))))

(deftest evaluar-de-test8
	(testing "Prueba 8 de la funcion: evaluar-de"
		(is (= '((*error* list expected 2) (x 1))
					(evaluar-de '(de f 2) '(x 1))))))

(deftest evaluar-de-test9
	(testing "Prueba 9 de la funcion: evaluar-de"
		(is (= '((*error* list expected 2) (x 1))
					(evaluar-de '(de f 2 3) '(x 1))))))

(deftest evaluar-de-test10
	(testing "Prueba 10 de la funcion: evaluar-de"
		(is (= '((*error* list expected nil) (x 1))
					(evaluar-de '(de (f)) '(x 1))))))

(deftest evaluar-de-test11
	(testing "Prueba 11 de la funcion: evaluar-de"
		(is (= '((*error* list expected x) (x 1))
					(evaluar-de '(de 2 x) '(x 1))))))

(deftest evaluar-de-test12
	(testing "Prueba 12 de la funcion: evaluar-de"
		(is (= '((*error* symbol expected 2) (x 1))
					(evaluar-de '(de 2 (x)) '(x 1))))))

(deftest evaluar-de-test13
	(testing "Prueba 13 de la funcion: evaluar-de"
		(is (= '((*error* cannot-set nil) (x 1))
					(evaluar-de '(de nil (x) 2) '(x 1))))))


; evaluar-if
(deftest evaluar-if-test1
	(testing "Prueba 1 de la funcion: evaluar-if"
		(is (= '(nil (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if t)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test2
	(testing "Prueba 2 de la funcion: evaluar-if"
		(is (= '(nil (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if 7)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test3
	(testing "Prueba 3 de la funcion: evaluar-if"
		(is (= '(nil (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test4
	(testing "Prueba 4 de la funcion: evaluar-if"
		(is (= '(nil (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if x)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test5
	(testing "Prueba 5 de la funcion: evaluar-if"
		(is (= '(9 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if t 9)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test6
	(testing "Prueba 6 de la funcion: evaluar-if"
		(is (= '(9 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if z 9)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test7
	(testing "Prueba 7 de la funcion: evaluar-if"
		(is (= '(9 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if w 9)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test8
	(testing "Prueba 8 de la funcion: evaluar-if"
		(is (= '((*error* unbound-symbol r) (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if r 9)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test9
	(testing "Prueba 9 de la funcion: evaluar-if"
		(is (= '(nil (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil 9)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test10
	(testing "Prueba 10 de la funcion: evaluar-if"
		(is (= '("hola" (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil 9 z)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test11
	(testing "Prueba 11 de la funcion: evaluar-if"
		(is (= '("hola" (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil 9 1 2 3 z)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test12
	(testing "Prueba 12 de la funcion: evaluar-if"
		(is (= '(3 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil 9 w)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test13
	(testing "Prueba 13 de la funcion: evaluar-if"
		(is (= '(8 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil 9 8)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test14
	(testing "Prueba 14 de la funcion: evaluar-if"
		(is (= '(8 (nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if nil a 8)
						'(nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test15
	(testing "Prueba 15 de la funcion: evaluar-if"
		(is (= '((*error* unbound-symbol a) (gt gt nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if (gt 2 0) a 8)
						'(gt gt nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test16
	(testing "Prueba 16 de la funcion: evaluar-if"
		(is (= '(8 (gt gt nil nil t t v 1 w 3 x 6))
					(evaluar-if '(if (gt 0 2) a 8)
						'(gt gt nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))

(deftest evaluar-if-test17
	(testing "Prueba 17 de la funcion: evaluar-if"
		(is (= '(8 (gt gt nil nil t t v 1 w 3 x 6 m 8))
					(evaluar-if '(if (gt 0 2) a (setq m 8))
						'(gt gt nil nil t t v 1 w 3 x 6)
						'(x 5 y 11 z "hola"))))))


; evaluar-or
(deftest evaluar-or-test1
	(testing "Prueba 1 de la funcion: evaluar-or"
		(is (= '(nil (nil nil t t w 5 x 4))
					(evaluar-or '(or) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test2
	(testing
		"Prueba 2 de la funcion: evaluar-or"
		(is (= '(nil (nil nil t t w 5 x 4))
					(evaluar-or '(or nil) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test3
	(testing "Prueba 3 de la funcion: evaluar-or"
		(is
			(= '(t (nil nil t t w 5 x 4))
				(evaluar-or '(or t) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test4
	(testing "Prueba 4 de la funcion: evaluar-or"
		(is
			(= '(5 (nil nil t t w 5 x 4))
				(evaluar-or '(or w) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test5
	(testing "Prueba 5 de la funcion: evaluar-or"
		(is
			(= '((*error* unbound-symbol r) (nil nil t t w 5 x 4))
				(evaluar-or '(or r) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test6
	(testing "Prueba 6 de la funcion: evaluar-or"
		(is
			(= '(nil (nil nil t t w 5 x 4))
				(evaluar-or '(or y) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test7
	(testing "Prueba 7 de la funcion: evaluar-or"
		(is
			(= '(6 (nil nil t t w 5 x 4))
				(evaluar-or '(or 6) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test8
	(testing
		"Prueba 8 de la funcion: evaluar-or"
		(is (= '(6 (nil nil t t w 5 x 4))
					(evaluar-or '(or nil 6) '(nil nil t t w 5 x 4) '(x 1 y nil z 3))))))

(deftest evaluar-or-test9
	(testing "Prueba 9 de la funcion: evaluar-or"
		(is (= '(8 (nil nil t t w 5 x 4 b 8))
					(evaluar-or '(or (setq b 8) nil)
						'(nil nil t t w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-or-test10
	(testing "Prueba 10 de la funcion: evaluar-or"
		(is (= '(6 (nil nil t t w 5 x 4))
					(evaluar-or '(or nil 6 nil)
						'(nil nil t t w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-or-test11
	(testing "Prueba 11 de la funcion: evaluar-or"
		(is (= '(6 (nil nil t t w 5 x 4))
					(evaluar-or '(or nil 6 r nil)
						'(nil nil t t w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-or-test12
	(testing "Prueba 12 de la funcion: evaluar-or"
		(is (= '(t (nil nil t t w 5 x 4))
					(evaluar-or '(or nil t r nil)
						'(nil nil t t w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-or-test13
	(testing "Prueba 13 de la funcion: evaluar-or"
		(is (= '(nil (nil nil t t w 5 x 4))
					(evaluar-or '(or nil nil nil nil)
						'(nil nil t t w 5 x 4)
						'(x 1 y nil z 3))))))


; evaluar-setq
(deftest evaluar-setq-test1
	(testing "Prueba 1 de la funcion: evaluar-setq"
		(is (= '((*error* list expected nil) (nil nil t t + add w 5 x 4))
					(evaluar-setq '(setq)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test2
	(testing "Prueba 2 de la funcion: evaluar-setq"
		(is (= '((*error* list expected nil) (nil nil t t + add w 5 x 4))
					(evaluar-setq '(setq m)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test3
	(testing "Prueba 3 de la funcion: evaluar-setq"
		(is (= '((*error* list expected nil) (nil nil t t + add w 5 x 4))
					(evaluar-setq '(setq nil)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test4
	(testing "Prueba 4 de la funcion: evaluar-setq"
		(is (= '((*error* cannot-set nil) (nil nil t t + add w 5 x 4))
					(evaluar-setq '(setq nil 7)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test5
	(testing "Prueba 5 de la funcion: evaluar-setq"
		(is (= '((*error* symbol expected 7) (nil nil t t + add w 5 x 4))
					(evaluar-setq '(setq 7 8)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test6
	(testing "Prueba 6 de la funcion: evaluar-setq"
		(is (= '((*error* list expected nil) (nil nil t t + add w 5 x 7))
					(evaluar-setq '(setq x 7 y)
						'(nil nil t t + add w 5 x 4)
						'(y nil z 3))))))

(deftest evaluar-setq-test7
	(testing "Prueba 7 de la funcion: evaluar-setq"
		(is (= '(7 (nil nil t t + add w 5 x 4 m 7))
					(evaluar-setq '(setq m 7)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test8
	(testing "Prueba 8 de la funcion: evaluar-setq"
		(is (= '(7 (nil nil t t + add w 5 x 7))
					(evaluar-setq '(setq x 7)
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test9
	(testing "Prueba 9 de la funcion: evaluar-setq"
		(is (= '(9 (nil nil t t + add w 5 x 7 y 8 z 9))
					(evaluar-setq '(setq x 7 y 8 z 9)
						'(nil nil t t + add w 5 x 4)
						'(y nil z 3))))))

(deftest evaluar-setq-test10
	(testing "Prueba 10 de la funcion: evaluar-setq"
		(is (= '(2 (nil nil t t + add w 5 x 2))
					(evaluar-setq '(setq x (+ x 1))
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test11
	(testing "Prueba 11 de la funcion: evaluar-setq"
		(is (= '(5 (nil nil t t + add w 5 x 5))
					(evaluar-setq '(setq x (+ x 1))
						'(nil nil t t + add w 5 x 4)
						'(y nil z 3))))))

(deftest evaluar-setq-test12
	(testing "Prueba 12 de la funcion: evaluar-setq"
		(is (= '(8 (nil nil t t + add w 5 x 7 m 8))
					(evaluar-setq '(setq x 7 m (+ x 7))
						'(nil nil t t + add w 5 x 4)
						'(x 1 y nil z 3))))))

(deftest evaluar-setq-test13
	(testing "Prueba 13 de la funcion: evaluar-setq"
		(is (= '(14 (nil nil t t + add w 5 x 7 m 14))
					(evaluar-setq '(setq x 7 m (+ x 7))
						'(nil nil t t + add w 5 x 4)
						'(y nil z 3))))))
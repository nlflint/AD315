#lang racket

(define (factorial x)
  (letrec ([factorial-rec (lambda (x acc)
                            (if (= x 0)
                                acc
                                (factorial-rec (- x 1) (* acc x))))])
    (factorial-rec x 1)))

(factorial 5)

(define (n-choose-k n k)
  (let ([new-n (- n 1)])
  (/ (factorial new-n)  (* (factorial k) (factorial (- new-n k))))))

(define (polynomials n)
  (let ([new-n (+ n 1)])
    (map (lambda (x) (n-choose-k new-n x)) (range new-n) )))

(define factors (polynomials 4))

(define (middle items)
  (cdr (reverse (cdr items))))

(define middle-factors (middle factors))

(define (decorate-factor coef p)
  (let ([coefficient (cond
                   [(null? coef) ""]
                   [(= coef 1) ""]
                   [else (number->string coef)])]
        [power (cond
                 [(= p 1) ""]
                 [else (string-append "^" (number->string p))])])
    (string-append coefficient "XY" power)))

(define (decorate-factors factors)
  (let ([starting-power (+ (/ (count factors) 2) 1)])
    starting-power))

(decorate-factor 12 1)

(decorate-factors factors)






  
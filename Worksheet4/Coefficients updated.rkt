#lang racket
(define n-power 5)

(define (factorial x)
  (letrec ([factorial-rec (lambda (x acc)
                            (if (= x 0)
                                acc
                                (factorial-rec (- x 1) (* acc x))))])
    (factorial-rec x 1)))

(define (n-choose-k n k)
  (/ (factorial n)  (* (factorial k) (factorial (- n k)))))

(define (pascals-triangle-at-row row) (map (lambda (x) (n-choose-k row x)) (range (+ row 1)) ))

(define coefficients (pascals-triangle-at-row n-power))

(define powers
  (let* ([real-count (/ (+ n-power 1) 2)]
         [powers (range 1 (+ 1 real-count))])
    (append powers (reverse powers))))
    
(define (blend coefficients powers)
  (if (not (pair? coefficients))
      null
      (cons (cons (car coefficients) (car powers)) (blend (cdr coefficients) (cdr powers)))))

(define (middle items)
  (cdr (reverse (cdr items))))


(define (print-it coefficients-and-powers)
  (if (not (pair? coefficients-and-powers))
      ""
      (let* ([coefficient-and-power (car coefficients-and-powers)]
            [coefficient (car coefficient-and-power)]
            [power (cdr coefficient-and-power)])
        (string-append (number->string coefficient) "XY^" (number->string power) " + " (print-it (cdr coefficients-and-powers))))))

(define middle-final (print-it (middle (blend coefficients powers))))

(if (> n-power 0)
    (string-append "X^2 + " middle-final " Y^2")
    "X + Y")







  
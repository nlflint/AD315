#lang racket

(define (recur-fib count fibs)
              (if (<= count 0)
                  fibs
                  (recur-fib (- count 1)
                             (cons (+ (car fibs) (car (cdr fibs)))
                              fibs))))

(define (calculate-fibs a)
  (reverse (recur-fib (- a 2) '(1 1))))

(define (ratio-pairs items)
  (if (not (pair? (cdr items)))
      null
      (cons (/ (car (cdr items)) (car items )) (ratio-pairs (cdr items)))))

(calculate-fibs 50)

(map exact->inexact
     (ratio-pairs (calculate-fibs 50)))

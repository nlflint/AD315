#lang racket

(define (calculate-fibs a)
  (reverse (recur-fib (- a 2) '(1 1))))

(define (recur-fib count fibs)
  (if (<= count 0)
      fibs
      (recur-fib (- count 1) (cons
                              (+ (car fibs) (car (cdr fibs)))
                              fibs))))


(define (ratio-pairs items)
  (if (not (pair? (cdr items)))
      '()
      (cons (/ (car (cdr items)) (car items )) (ratio-pairs (cdr items)))))

(define ratios (ratio-pairs (calculate-fibs 50)))

ratios

(calculate-fibs 10)
(map exact->inexact ratios)





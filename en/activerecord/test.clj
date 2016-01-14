(->> (range 100)
     (filter odd?)
     (map inc)
     (apply +))

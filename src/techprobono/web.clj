(ns techprobono.web)
(use 'ring.adapter.jetty)
(use 'techprobono.core)

(defn -main
  []
  (run-jetty handler {:port 3000}))

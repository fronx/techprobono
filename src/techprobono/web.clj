(ns techprobono.web
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]))

(defroutes web-routes
  (GET "/hello-world" [] "hello-world")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app (handler/site web-routes))

(defn start [port]
  (ring/run-jetty (var app) {:port (or port 8080)
                             :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))

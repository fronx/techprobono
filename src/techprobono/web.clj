(ns techprobono.web
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]))

(defroutes web-routes
  (GET "/hello-world" [] "hello-world")
  (route/resources "/")
  (route/not-found "Not Found"))

(defn rewrite-map [uri]
  (or ({ "/" "/index.html"
       } uri)
      uri))

(defn uri-rewrites [handler]
  (fn [req]
    (handler
      (update-in req [:uri] rewrite-map))))

(def app (-> (handler/site web-routes)
             (uri-rewrites)))

(defn start [port]
  (ring/run-jetty (var app) {:port (or port 8080)
                             :join? false}))

(defn -main []
  (let [port (Integer. (System/getenv "PORT"))]
    (start port)))

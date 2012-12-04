(ns techprobono.app
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/hello-world" [] "hello-world")
  (route/files "/" {:root (str (System/getProperty "user.dir") "/public")})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

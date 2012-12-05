(defproject techprobono "0.1.0-SNAPSHOT"
  :description "techprobono"
  :url "http://techprobono.org"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/java.jdbc "0.1.1"]
                 [compojure "1.1.3"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [ring/ring-jetty-adapter "1.0.0-RC1"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler techprobono.routes/app}
  :profiles
    {:dev {:dependencies [[ring-mock "0.1.3"]]}})
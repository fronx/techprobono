(defproject techprobono "0.1.0-SNAPSHOT"
  :description "techprobono"
  :url "http://techprobono.org"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.3"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler techprobono.routes/app}
  :profiles
    {:dev {:dependencies [[ring-mock "0.1.3"]]}})
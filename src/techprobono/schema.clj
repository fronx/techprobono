(ns techprobono.schema
  (:require [clojure.java.jdbc :as sql]))

(def database-url (System/getenv "DATABASE_URL"))

(defn create-good-causes []
  (sql/with-connection database-url
    (sql/create-table :good_causes
                      [:id :serial "PRIMARY KEY"]
                      [:name :varchar "NOT NULL"]
                      [:body :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn -main []
  (print "Creating tables...") (flush)
  (create-good-causes)
  (println " done"))

; foreman run lein run -m techprobono.schema

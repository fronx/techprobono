(ns techprobono.data
  (:require [clojure.java.jdbc :as sql]))

(def database-url (System/getenv "DATABASE_URL"))

(defn good-causes []
  (sql-select "select * from good_causes")

(defn sql-select [query]
  (sql/with-connection database_url
    (sql/with-query-results results [query] (into [] results))))

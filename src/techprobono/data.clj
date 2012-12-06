(ns techprobono.data
  (:require [clojure.java.jdbc :as sql]))

(def database-url (System/getenv "DATABASE_URL"))

(defn sql-select [query]
  (sql/with-connection database-url
    (sql/with-query-results results query (doall results))))

(defn fetch-good-causes []
  (sql-select ["select * from good_causes"]))

(defn create-good-cause [good-cause]
  (sql/with-connection database-url
    (sql/insert-records :good_causes good-cause)))

(defn fetch-good-cause [id]
  (sql-select ["select * from good_causes where id = ?" (Integer/parseInt id)]))

(comment
  ; foreman run lein repl
  (use 'techprobono.data)
  (create-good-cause {:name "We are super good" :body "This is meant to be much longer.\nIt even has multiple lines of text."})
  (fetch-good-cause 1)
)

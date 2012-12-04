(ns techprobono.test.app
  (:use clojure.test
        ring.mock.request
        techprobono.app))

(deftest test-app
  (testing "index page"
    (let [response (app (request :get "/index.html"))]
      (is (= (:status response) 200))))

  (testing "main route"
    (let [response (app (request :get "/hello-world"))]
      (is (= (:status response) 200))
      (is (= (:body response) "hello-world"))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

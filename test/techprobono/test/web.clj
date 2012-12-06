(ns techprobono.test.web
  (:use clojure.test
        ring.mock.request
        techprobono.web))

(deftest test-web
  (testing "index page"
    (let [response (app (request :get "/index.html"))]
      (is (= (:status response) 200))))

  (testing "good causes route"
    (let [response (app (request :get "/good-causes"))]
      (is (= (:status response) 200))))

  (testing "good cause route"
    (let [response (app (request :get "/good-cause/1"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

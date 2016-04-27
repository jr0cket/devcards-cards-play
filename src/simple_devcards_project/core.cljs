(ns simple-devcards-project.core
  (:require
   #_[om.core :as om :include-macros true]
   [sablono.core :as sab :include-macros true])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]))

(enable-console-print!)


(def deck ["cards" [[10 "clubs"] ["queen" "diamonds"]]])


(defcard first-card
  (sab/html [:div
             [:h1 "This is your first devcard!"]]))


;; (defcard zeroth-card
;;   "A react component"
;;   (fn [data _]
;;     (reagent/as-element [(input-text-field
;;                           #(do (println "Current value:" %)
;;                                (reset! data {:value %})))])))

;; {:value nil}
;; {:inspect-data true
;;  :frame        true
;;  :history      true}

;; (defcard show-the-card
;;   (fn [data _])
;;   (reagent/as-element [playing-card data]))

;; (defn input-text-field
;;   [dispatch-fn]
;;   (let [val (reagent/atom "")]
;;     (fn []
;;       [:input {:type  "text"}])))


(defn card->img
  "Takes a card structrure and tget the respecitve image"
  [[rank suit]]
  (str "/image/cards/" rank "_of_" suit ".png"))

;; initially we can hard code the card number
;; (defcard playing-card-test
;;   (sab/html [:img {:src "/image/cards/2_of_hearts.png"}]))

;; refactor to use a function call 
(defcard playing-card-test
  (fn []
    #_(println ">>>" @data)
    (sab/html [:img {:src (card->img [3 "clubs"])
                     :width "200px"}])))


(defn main []
  ;; conditionally start the app based on wether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:div "This is working"]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html


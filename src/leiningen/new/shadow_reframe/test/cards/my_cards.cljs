(ns cards.my-cards
  (:require   
   [reagent.core :as rc]
   [devcards.core])
  (:require-macros
   [devcards.core :as dc :refer [defcard-rg]]))

;; This is your main devcards name space
;; If you add additional name spaces with cards require them here
;; so they'llshow up in the ui

(defcard-rg sample-card
  [:div
   [:h1 "My first devcard"]
   [:div "See the following links for details:"
    [:ul
     [:li [:a {:href "https://github.com/bhauman/devcards"} "DevCards home"]]
     [:li [:a {:href "http://rigsomelight.com/devcards/#!/devdemos.reagent"} "DevCard with reagent"]]
     ]]])


(devcards.core/start-devcard-ui!)

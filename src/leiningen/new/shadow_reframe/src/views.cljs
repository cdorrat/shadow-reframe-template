(ns {{ns-name}}.views
  (:require [re-frame.core :as re-frame]
            [{{ns-name}}.subs :as subs]
            [{{ns-name}}.events :as evts]
            [goog.object :as g-obj]
            [cljsjs.semantic-ui-react :as sui]
            [reagent.core :as rc]
            [soda-ash.core :as sa]
            [reagent.format :as rf]
            ))

;; home

(defn section-button [label url extra-props]
  [:a {:href url :style {:margin-top "20px"}}
   [sa/Button (merge {:size :massive :fluid true :className "demo-section-button"} extra-props)
    label]])

(def panel-inline-style
  {:display "flex" :flex-direction "column"
   :justify-content "center"  :align-items "center"
   :padding-top "30px"})

(defn home-panel []
  
  (let [name (re-frame/subscribe [::subs/name])]
    [:div {:style panel-inline-style}
     [sa/Header {:as "h2"}
      [sa/Icon {:name "food"}] 
      [sa/HeaderContent {} @name]]
     [:div
      [section-button "Show About" "#/about" {:color "green"}]]]))


;; about
(defn about-panel []
  [:div {:style panel-inline-style}
   [sa/Header {:as "h2" :icon true}
    [sa/Icon {:name "settings"}]
    "About Page"
    [sa/HeaderSubheader {}
     "All of your abaut needs are here"]]
   [:div
    [section-button "Back to Home" "#/" {:color "blue"}]]]) 


;; main
(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div "Panel not found"]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))

(ns {{ns-name}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [{{ns-name}}.events :as events]
            [{{ns-name}}.routes :as routes]
            [{{ns-name}}.views :as views]
            [{{ns-name}}.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))

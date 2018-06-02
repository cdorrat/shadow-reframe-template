(ns leiningen.new.shadow-reframe
  (:require [leiningen.new.templates :refer [renderer sanitize-ns name-to-path ->files]]
            [leiningen.core.main :as main]
            [leiningen.new.options.helpers :as helpers]
            [leiningen.new.options.base :as base]
            [leiningen.new.options.devcards :as devcards]
            [leiningen.new.options.less :as less]))

(def render (renderer "shadow-reframe"))

(defn app-files [data options]
  (concat
   (base/files data)
   (devcards/files data)
   (less/files data)))

(defn template-data [name options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)
   
   :less?     (helpers/invoke-option less/option options)   
   :devcards? (helpers/invoke-option devcards/option options)   
   })


(defn shadow-reframe  [name & options]
;;; enable all options at the moment
  (let [options [less/option devcards/option] 
        data (template-data name options)]
    (main/info "Generating shadow-reframe project.")
    (apply ->files data
           (app-files data options)))
  
  )

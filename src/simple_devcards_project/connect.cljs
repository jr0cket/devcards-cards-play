(ns simple-devcards-project.connect
  (:require [chord.client :refer [ws-ch]]
            [cljs.core.async :refer [<! >! put! close!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))



(defn get-data []
  (go
    (let [{:keys [ws-channel error]} (<! (ws-ch "ws://maruks.homelinux.org:8080/ws"))]
      (if-not error
        (>! ws-channel "Hello server from client!")
        (js/console.log "Error:" (pr-str error))))))

    while next_event and time > next_event.Time do
        if next_event.Type == "Attack" then
          self:onAttackFrame()
          ed.engine:deliverBall(self.caster, self, self.attack_counter)
        end
        if self.casting then
          local idx = self.next_event_idx + 1
          next_event = self.current_phase.event_list[idx]
          self.next_event_idx = idx
          self.next_event = next_event
        end
    end
while a do
  f()
end
while a do
  if b then
    f()
  end
end
while a do
  while b do
    f()
  end
  g()
end
while a do
  f()
  while b do
    g()
  end
end

local function getLvupAtt(self, id)
    local att = {}
    local row = ed.getDataTable("SkillGroup")[self.hid][id]
    local index = 1
    while true do
        local field = row["Growth " .. index .. " Field"]
        if field then
            local popupstr=row["grouth"]
            if popupstr then
                index=index+1
            else
                break
            end
        else
            break
        end
    end
    return att
end
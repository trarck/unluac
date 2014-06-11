local h = function()
  return {a = 2}
end
local g = h().a

print(g)

local a

local b=(a or {})["c"]


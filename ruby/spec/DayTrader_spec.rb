name, json = init(__FILE__)

describe name do
  json.each_with_index do |data, i|
    it "test #{i}" do
      test(name, data, float: true)
    end
  end
end
